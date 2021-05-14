package schema

import org.jooq.codegen.GenerationTool
import org.jooq.meta.jaxb.*
import org.jooq.meta.jaxb.Target
import java.util.*

fun main() {
    GenerationTool.generate(Configuration().apply {
        jdbc = Jdbc().apply {
            driver = "org.postgresql.Driver"
            url = "jdbc:postgresql://localhost:9557/komodo_crm"
            user = "komodo"
            password = "komodo"
        }

        generator = Generator().apply {
            name = "org.jooq.codegen.KotlinGenerator"
            database = Database().apply {
                name = "org.jooq.meta.postgres.PostgresDatabase"
                includes = ".*"
                inputSchema = "public"
            }

            generate = Generate().apply {
                isDaos = true
                isPojosAsKotlinDataClasses = true
            }

            target = Target().apply {
                packageName = "io.heapy.crm.komodo.store.postgres"
                directory = "./backend-store-postgres/src/main/kotlin"
                locale = Locale.ROOT.toLanguageTag()
            }
        }
    })
}
