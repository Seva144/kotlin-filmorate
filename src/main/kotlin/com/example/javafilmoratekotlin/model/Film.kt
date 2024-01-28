package com.example.javafilmoratekotlin.model

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate
import javax.validation.constraints.*

@Schema(description = "Информация о фильме")
class Film(

    @Schema(description = "Идентификатор фильма")
    private var id: Int,
    @Schema(description = "Наименование фильма")
    @NotBlank
    private var name: String,
    @Schema(description = "Описание фильма")
    @Size(max = 200)
    private var description: String,
    @Schema(description = "Дата релиза фильма")
    @Past
    private var releaseDate: LocalDate,
    @Schema(description = "Продолжительность фильма")
    @Positive
    private var duration: Int
) {

    fun getId(): Int = id
    fun getName(): String = name
    fun getDescription(): String = description
    fun getReleaseDate(): LocalDate = releaseDate
    fun getDuration(): Int = duration

    fun setId(id: Int) {
        this.id = id
    }

    fun setName(name: String) {
        this.name = name
    }

    fun setDescription(description: String) {
        this.description = description
    }

    fun setReleaseDate(releaseDate: LocalDate) {
        this.releaseDate = releaseDate
    }

    fun setDuration(duration: Int) {
        this.duration = duration
    }


}
