package io.heapy.crm.komodo

import com.typesafe.config.ConfigFactory
import io.github.config4k.extract
import io.undertow.Undertow
import io.undertow.server.HttpHandler
import org.slf4j.LoggerFactory
import java.lang.management.ManagementFactory

fun main() {
    ApplicationFactory().run()
}

open class ApplicationFactory {
    open val configuration: Configuration by lazy {
        ConfigFactory.load().extract()
    }

    open val rootHandler: HttpHandler by lazy {
        HttpHandler {
            it.responseSender.send("Hello, World!")
        }
    }

    open val server: Undertow by lazy {
        Undertow
            .builder()
            .addHttpListener(
                configuration.undertow.port,
                configuration.undertow.host,
                rootHandler
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
        val LOGGER = LoggerFactory.getLogger(ApplicationFactory::class.java)
    }
}

data class Configuration(
    val undertow: UndertowConfiguration,
)

data class UndertowConfiguration(
    val port: Int,
    val host: String,
)
