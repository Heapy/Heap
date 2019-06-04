package io.heapy.heap.dao

/**
 * Provides dao classes used by service layer
 *
 * @author Ruslan Ibragimov
 * @since 1.0.0
 */
interface DaoModule {
    companion object
}

internal class DefaultDaoModule : DaoModule

fun DaoModule.Companion.default(): DaoModule {
    return DefaultDaoModule()
}
