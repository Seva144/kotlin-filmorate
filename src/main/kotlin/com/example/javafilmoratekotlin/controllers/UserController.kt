package com.example.javafilmoratekotlin.controllers

import com.example.javafilmoratekotlin.model.User
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping( "/users")
class UserController {

    private final val users = HashMap<Int, User> (4)

    protected val id: Int = 0

    @GetMapping
    fun returnAllUsers(): ArrayList<User> {
        return ArrayList(users.values)
    }

    @PostMapping
    fun createUser (@Valid @RequestBody user: User): User {
        validateUser(user)
        user.setId(generateId())
        users.put(user.getId(), user)
        return user
    }

    @PutMapping
    fun changeUser (@Valid @RequestBody user: User): User {
        validateUser(user)
        if(users.containsKey(user.getId()))
            users.replace(user.getId(), user)
        else
            throw Exception ("Неверный ID")
        return user;
    }

    fun validateUser (user: User){
        if (user.getName() == null){
            user.setName(user.getLogin())
        }
    }

    fun generateId(): Int {
        return id.inc()
    }

}