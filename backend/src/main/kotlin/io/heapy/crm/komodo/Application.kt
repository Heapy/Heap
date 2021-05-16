@file:JvmName("Application")
package io.heapy.crm.komodo

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import io.github.config4k.extract
import io.undertow.Handlers.websocket
import io.undertow.Undertow
import io.undertow.server.HttpHandler
import io.undertow.server.handlers.PathHandler
import io.undertow.server.handlers.resource.PathResourceManager
import io.undertow.server.handlers.resource.ResourceHandler
import io.undertow.websockets.core.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.management.ManagementFactory
import java.nio.file.Path


fun main() {
    ApplicationFactory().run()
}

open class ApplicationFactory {
    open val configuration: Config by lazy {
        ConfigFactory.load()
    }

    open val undertowConfiguration: UndertowConfiguration by lazy {
        configuration.extract("undertow")
    }

    open val rootHandler: HttpHandler by lazy {
        PathHandler()
            .addExactPath("/ws", websocket { exchange, channel ->
                GlobalScope.launch {
                    while (isActive) {
                        delay(500000)
                        channel.peerConnections.forEach {
                            WebSockets.sendText(
                                "reload", it,
                                object : WebSocketCallback<Void> {
                                    override fun complete(channel: WebSocketChannel?, context: Void?) {
                                        println("ok")
                                    }

                                    override fun onError(
                                        channel: WebSocketChannel?,
                                        context: Void?,
                                        throwable: Throwable?
                                    ) {
                                        println("error")
                                    }
                                },
                            )
                        }
                    }
                }

                channel.receiveSetter.set(object : AbstractReceiveListener() {
                    override fun onFullTextMessage(channel: WebSocketChannel, message: BufferedTextMessage) {
                        val messageData = message.data
                        for (session in channel.peerConnections) {
                            WebSockets.sendText(messageData, session, null)
                        }
                    }
                })
                channel.resumeReceives()
            })
    }

    open val resourcesHandler by lazy {
        ResourceHandler(
            PathResourceManager(undertowConfiguration.resources),
            rootHandler
        )
    }

    open val server: Undertow by lazy {
        Undertow
            .builder()
            .addHttpListener(
                undertowConfiguration.port,
                undertowConfiguration.host,
                resourcesHandler
            )
            .build()
    }

    open fun configureLogging() {
        System.setProperty("org.jboss.logging.provider", "slf4j")
    }

    open fun run() {
        configureLogging()
        server.start()
        LOGGER.info("Application started. JVM running for ${ManagementFactory.getRuntimeMXBean().uptime}ms")
    }

    companion object {
        val LOGGER: Logger = LoggerFactory.getLogger(ApplicationFactory::class.java)
    }
}

data class UndertowConfiguration(
    val port: Int,
    val host: String,
    val resources: Path,
)
