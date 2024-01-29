package com.example.javafilmoratekotlin.controllers

import com.example.javafilmoratekotlin.model.User
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/users")
@Tag(name = "Контроллер полтьзователей", description = "API для CRUD пользователей")
class UserController {

    private final val users = HashMap<Int, User>(4)

    protected val id: Int = 0

    @GetMapping
    @Operation(summary = "Показать всех пользователей")
    fun returnAllUsers(): ArrayList<User> {
        return ArrayList(users.values)
    }

    @PostMapping
    @Operation(summary = "Добавить пользователя")
    fun createUser(@Parameter(required = true) @Valid @RequestBody user: User): User {
        validateUser(user)
        user.id
        users.put(user.id, user)
        return user
    }

    @PutMapping
    @Operation(summary = "Обноваить пользователя")
    fun changeUser(@Parameter(required = true) @Valid @RequestBody user: User): User {
        if (users.containsKey(user.id))
            users.replace(user.id, user)
        else
            throw Exception("Неверный ID")
        return user;
    }

    fun validateUser(user: User) {
        if (user.name == null) {
            user.name = user.login
        }
    }

    fun generateId(): Int {
        return id.inc()
    }
}
