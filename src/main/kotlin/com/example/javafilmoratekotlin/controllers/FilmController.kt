package com.example.javafilmoratekotlin.controllers

import com.example.javafilmoratekotlin.model.Film
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import javax.validation.Valid

@RestController
@RequestMapping("/films")
@Tag(name = "Контроллер фильмов", description = "API для CRUD фильмов")
class FilmController {

    private val films = HashMap<Int, Film>(4)

    protected val id: Int = 0

    @GetMapping
    @Operation(summary = "Показать все фильмы")
    fun returnAllFilms(): ArrayList<Film> {
        return ArrayList(films.values)
    }

    @PostMapping
    @Operation(summary = "Добавить фильм")
    fun createFilm(@Parameter(required = true) @Valid  @RequestBody film: Film): Film {
        validateFilm(film)
        film.id = generateId()
        films[film.id] = film
        return film
    }

    @PutMapping
    @Operation(summary = "Изменить фильм")
    fun changeFilm(@Parameter(required = true) @Valid @RequestBody film: Film): Film {
        validateFilm(film)
        if (films.containsKey(film.id))
            films.replace(film.id, film)
        else
            throw Exception("Неверный ID")
        return film
    }

    fun validateFilm(film: Film) {
        val trainArrival = LocalDate.of(2018, 12, 31)
        if (film.releaseDate.isBefore(trainArrival))
            throw Exception("Некорретная дата")
    }

    fun generateId(): Int {
        return id.inc()
    }

}