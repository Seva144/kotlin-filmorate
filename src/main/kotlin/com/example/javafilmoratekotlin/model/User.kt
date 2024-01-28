package com.example.javafilmoratekotlin.model

import io.swagger.v3.oas.annotations.media.Schema

import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Past

@Schema(description = "Информация о пользователе")
class User(

    @Schema(description = "Идентификатор пользователя")
    private var id: Int,
    @Schema(description = "Почта пользователя")
    @Email
    private var email: String,
    @Schema(description = "Логин пользователя")
    @NotBlank
    private var login: String,
    @Schema(description = "Имя пользователя")
    private var name: String?,
    @Schema(description = "Дата рождения")
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