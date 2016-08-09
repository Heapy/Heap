package by.heap.web

import by.heap.dao.jooq.Tables.FILMS
import by.heap.dao.jooq.tables.daos.FilmsDao
import by.heap.dao.jooq.tables.pojos.Films
import by.heap.dao.jooq.tables.records.FilmsRecord
import by.heap.web.authentication.UserController
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.RecordMapper
import org.jooq.impl.DefaultConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct


@Configuration
@EnableAutoConfiguration
open class Application {

    @Bean open fun userController() = UserController()

    @Autowired
    lateinit var config: DefaultConfiguration;

    @Autowired
    lateinit var context: DSLContext;

    @PostConstruct
    fun test() {

        val dao = FilmsDao(config)

        context.insertInto(FILMS)
                .set(FILMS.CODE, "STRIN")
                .set(FILMS.TITLE, "ABC")
                .set(FILMS.DID, 42).execute()

        // or

        class FilmDto(name: String)

        val fooMapper: RecordMapper<FilmsRecord, Any> = RecordMapper<FilmsRecord, Any> { r: FilmsRecord -> FilmDto(r.title) }

        dao.insert(Films().apply {

        })

        val c = dao.fetchByCode("STRIN")

        println(c)
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}