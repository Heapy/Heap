import org.jooq.util.GenerationTool
import org.jooq.util.jaxb.Configuration
import org.jooq.util.jaxb.Database
import org.jooq.util.jaxb.Generate
import org.jooq.util.jaxb.Generator
import org.jooq.util.jaxb.Jdbc
import org.jooq.util.jaxb.Target

fun main(args: Array<String>) {
    GenerationTool.generate(Configuration().apply {
        jdbc = Jdbc().apply {
            driver = "org.postgresql.Driver"
            url = "jdbc:postgresql://localhost:5432/heap"
            user = "postgres"
            password = "xByFyWQwilF6BOa"
        }

        generator = Generator().apply {
            database = Database().apply {
                name = "org.jooq.util.postgres.PostgresDatabase"
                includes = ".*"
                inputSchema = "public"
            }

            generate = Generate().apply {
                isDaos = true
            }

            target = Target().apply {
                packageName = "by.heap.dao.jooq"
                directory = "./heap-dao/src/main/kotlin"
            }
        }
    })
}