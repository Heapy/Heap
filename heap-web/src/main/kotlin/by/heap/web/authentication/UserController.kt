package by.heap.web.authentication

import by.heap.dao.User
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @RequestMapping("/hello")
    fun hello() = "Hello!"

    @RequestMapping("/user")
    fun getUser() = User("Ruslan")
}