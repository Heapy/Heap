package io.heapy.heap.api.routes

import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.util.pipeline.ContextDsl

/**
 * Healthcheck
 *
 * @author Ruslan Ibragimov
 * @since 1.0.0
 */
@ContextDsl
fun Route.health() {
    get("/healthcheck") {
        call.respond(ok)
    }
}

private val ok = HealthStatus(200)

internal class HealthStatus(
    val status: Int
)
