/*
 * This file is generated by jOOQ.
 */
package io.heapy.crm.komodo.store.postgres


import io.heapy.crm.komodo.store.postgres.tables.FlywaySchemaHistory
import io.heapy.crm.komodo.store.postgres.tables.Person

import kotlin.collections.List

import org.jooq.Catalog
import org.jooq.Table
import org.jooq.impl.SchemaImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Public : SchemaImpl("public", DefaultCatalog.DEFAULT_CATALOG) {
    companion object {

        /**
         * The reference instance of <code>public</code>
         */
        val PUBLIC = Public()
    }

    /**
     * The table <code>public.flyway_schema_history</code>.
     */
    val FLYWAY_SCHEMA_HISTORY get() = FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY

    /**
     * The table <code>public.person</code>.
     */
    val PERSON get() = Person.PERSON

    override fun getCatalog(): Catalog = DefaultCatalog.DEFAULT_CATALOG

    override fun getTables(): List<Table<*>> = listOf(
        FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY,
        Person.PERSON
    )
}