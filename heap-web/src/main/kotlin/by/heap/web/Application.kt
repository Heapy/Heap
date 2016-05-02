package by.heap.web

import by.heap.dao.jooq.tables.Films
import by.heap.web.authentication.UserController
import org.jooq.DSLContext
import org.jooq.impl.DSL
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
    lateinit var create: DSLContext;

    @PostConstruct
    fun test() {
        var f = Films()

        create.insertInto(f)
                .set(f.CODE, "IRUS")
                .set(f.TITLE, "NICE")
                .set(f.DID, 42)
                .execute()

        val r = create.select(f.CODE).from(f).fetch()


        println(r)
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}