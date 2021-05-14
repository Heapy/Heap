package schema

import org.flywaydb.core.Flyway

fun main() {
    val flyway: Flyway = Flyway.configure().dataSource(
        "jdbc:postgresql://localhost:9557/komodo_crm",
        "komodo",
        "komodo"
    ).load()
    flyway.migrate()
}
