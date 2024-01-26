package com.example.javafilmoratekotlin.controllers

import com.example.javafilmoratekotlin.model.Film
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*
import java.time.LocalDate


@RestController
@RequestMapping("/films")
class FilmController {

    private val films = HashMap<Int, Film>(4)

    protected val id: Int = 0

    @GetMapping
    fun returnAllFilms(): ArrayList<Film> {
        return ArrayList(films.values)
    }

    @PostMapping
    fun createFilm(@Valid @RequestBody film: Film): Film {
        validateFilm(film)
        film.setId(generateId())
        films[film.getId()] = film
        return film
    }

    @PutMapping
    fun changeFilm(@Valid @RequestBody film: Film): Film {
        validateFilm(film)
        if (films.containsKey(film.getId()))
            films.replace(film.getId(), film)
        else
            throw Exception("Неверный ID")
        return film
    }

    fun validateFilm(film: Film) {
        val trainArrival = LocalDate.of(2018, 12, 31)
        if (film.getReleaseDate().isBefore(trainArrival))
            throw Exception("Некорретная дата")
    }

    fun generateId(): Int {
        return id.inc()
    }

}