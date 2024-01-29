package com.example.javafilmoratekotlin.model

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate
import javax.validation.constraints.*

@Schema(description = "Информация о фильме")
data class Film(

    @Schema(description = "Идентификатор фильма")
    var id: Int,
    @Schema(description = "Наименование фильма")
    @NotBlank
    var name: String,
    @Schema(description = "Описание фильма")
    @Size(max = 200)
    var description: String,
    @Schema(description = "Дата релиза фильма")
    @Past
    var releaseDate: LocalDate,
    @Schema(description = "Продолжительность фильма")
    @Positive
    var duration: Int
)
