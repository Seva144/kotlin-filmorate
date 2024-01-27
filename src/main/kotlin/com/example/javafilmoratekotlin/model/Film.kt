package com.example.javafilmoratekotlin.model

import jakarta.validation.constraints.*
import java.time.LocalDate

class Film(
    private var id: Int,
    @NotBlank
    private var name: String,
    @Size(max = 200)
    private var description: String,
    @Past
    private var releaseDate: LocalDate,
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
