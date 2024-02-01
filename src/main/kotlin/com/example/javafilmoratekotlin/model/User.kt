package com.example.javafilmoratekotlin.model

import io.swagger.v3.oas.annotations.media.Schema

import java.time.LocalDate
import javax.validation.constraints.*

/**
 * Дата класс User
 * @constructor конструктор класса
 * @param id идентификатор пользователя
 * @param email почта пользователя
 * @param login логин пользователя
 * @param name имя пользователя
 * @param birthday дата рождения пользователя
 */
@Schema(description = "Информация о пользователе")
data class User(

    @Schema(description = "Идентификатор пользователя")
    var id: Int,
    @Schema(description = "Почта пользователя")
    @Email
    var email: String,
    @Schema(description = "Логин пользователя")
    @NotBlank
    var login: String,
    @Schema(description = "Имя пользователя")
    var name: String?,
    @Schema(description = "Дата рождения")
    @Past
    var birthday: LocalDate
)