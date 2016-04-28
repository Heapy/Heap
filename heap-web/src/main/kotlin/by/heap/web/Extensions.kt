package by.heap.web

import org.slf4j.LoggerFactory

inline fun <reified T : Any> logger() = LoggerFactory.getLogger(T::class.java)

object L {
    operator fun <K> get(vararg items: K) = arrayListOf(*items)
}

object A {
    inline operator fun <reified K> get(vararg items: K) = arrayOf(*items)
}
