package by.heap.web

import by.heap.web.authentication.UserController
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
@EnableAutoConfiguration
open class Application {

    @Bean open fun userController() = UserController()
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}