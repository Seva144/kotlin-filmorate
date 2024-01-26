package com.example.javafilmoratekotlin.model

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Past
import java.time.LocalDate

class User(
    private var id: Int,
    @Email
    private var email: String,
    @NotBlank
    private var login: String,
    private var name: String?,
    @Past
    private var birthday: LocalDate
) {
    fun getId(): Int = id
    fun getEmail(): String = email
    fun getName(): String? = name
    fun getLogin(): String = login
    fun getReleaseDate(): LocalDate = birthday

    fun setId (id : Int){
        this.id = id
    }

    fun setEmail (email : String) {
        this.email = email
    }

    fun setLogin (login: String){
        this.login = login
    }

    fun setName (name: String){
        this.name = name
    }

    fun setBirthday (birthday: LocalDate){
        this.birthday = birthday
    }
}