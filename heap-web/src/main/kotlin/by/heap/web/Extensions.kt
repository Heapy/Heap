package by.heap.web

import org.slf4j.LoggerFactory

inline fun <reified T : Any> logger() = LoggerFactory.getLogger(T::class.java)
