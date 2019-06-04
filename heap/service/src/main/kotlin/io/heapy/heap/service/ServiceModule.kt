package io.heapy.heap.service

import io.heapy.heap.dao.DaoModule
import io.heapy.heap.dao.default

/**
 * Provides service classes used by api layer
 *
 * @author Ruslan Ibragimov
 * @since 1.0.0
 */
interface ServiceModule {
    companion object
}

internal class DefaultServiceModule : ServiceModule

fun ServiceModule.Companion.default(): ServiceModule {
    val dao = DaoModule.default()

    return DefaultServiceModule()
}
