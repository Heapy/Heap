package io.heapy.heap.api

import io.heapy.heap.api.routes.health
import io.heapy.heap.api.routes.static
import io.heapy.heap.service.ServiceModule
import io.heapy.heap.service.default
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.jackson.jackson
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

/**
 * Application entrypoint
 *
 * @author Ruslan Ibragimov
 * @since 1.0.0
 */
suspend fun main() {
    val service = ServiceModule.default()

    embeddedServer(Netty, 8080) {
        install(DefaultHeaders)
        install(CallLogging)
        install(ContentNegotiation) {
            jackson {}
        }

        routing {
            static()
            health()
        }
    }.start(wait = true)
}
