package io.heapy.heap.api.routes

import io.ktor.http.content.defaultResource
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.routing.Route
import io.ktor.util.pipeline.ContextDsl

/**
 * Serve site files from resources
 *
 * @author Ruslan Ibragimov
 * @since 1.0.0
 */
@ContextDsl
fun Route.static() {
    static {
        resources("static")
        defaultResource("static/index.html")
    }
}
