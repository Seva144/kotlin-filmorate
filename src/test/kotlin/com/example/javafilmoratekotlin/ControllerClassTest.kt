package com.example.javafilmoratekotlin

import com.example.javafilmoratekotlin.controllers.FilmController
import com.example.javafilmoratekotlin.parsing.ClassParser
import org.junit.jupiter.api.Test
import org.springframework.test.util.AssertionErrors
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import kotlin.reflect.full.*

class ControllerClassTest {

    private val parser = ClassParser()
    private val methodsFilm = FilmController::class.declaredMemberFunctions
    private val methodFilmJavaClass = FilmController::class.java.declaredMethods

    @Test
    fun testNameMethodReturnAllFilms() {
        val expected = methodsFilm.find { it.name == "returnAllFilms" }?.name
        val actual = parser.extractDataMethod(FilmController::class, "returnAllFilms").name
        AssertionErrors.assertEquals("Pass", actual, expected)
    }

    @Test
    fun testInputParametersMethodReturnAllFilms() {
        val expected = methodsFilm.find { it.name == "returnAllFilms" }?.valueParameters
        val actual = parser.extractDataMethod(FilmController::class, "returnAllFilms").inputParameters
        AssertionErrors.assertEquals("Pass", actual, expected)
    }

    @Test
    fun testOutputParametersMethodReturnAllFilms() {
        val expected = methodsFilm.find { it.name == "returnAllFilms" }?.returnType
        val actual = parser.extractDataMethod(FilmController::class, "returnAllFilms").outputParameter
        AssertionErrors.assertEquals("Pass", actual, expected)
    }

    @Test
    fun testGetAnnotationMethodReturnAllFilms() {
        val expected = methodFilmJavaClass.find { it.name == "returnAllFilms" }
            ?.getAnnotation(GetMapping::class.java)
        val actual = parser.extractDataAnnotationGetMethod(
            FilmController::class,
            "returnAllFilms",
            GetMapping::class.java
        ).annotation
        AssertionErrors.assertEquals("Pass", actual, expected)
    }

    @Test
    fun testDescriptionAnnotationMethodReturnAllFilms() {
        val expected = methodFilmJavaClass.find { it.name == "returnAllFilms" }
            ?.getAnnotation(io.swagger.v3.oas.annotations.Operation::class.java)?.summary
        val actual = parser.extractDataAnnotationMethod(FilmController::class, "returnAllFilms").description
        AssertionErrors.assertEquals("Pass", actual, expected)
    }

    @Test
    fun testNameMethodCreateFilm() {
        val expected = methodsFilm.find { it.name == "createFilm" }?.name
        val actual = parser.extractDataMethod(FilmController::class, "createFilm").name
        AssertionErrors.assertEquals("Pass", actual, expected)
    }

    @Test
    fun testInputParametersMethodCreateFilm() {
        val expected = methodsFilm.find { it.name == "createFilm" }?.valueParameters
        val actual = parser.extractDataMethod(FilmController::class, "createFilm").inputParameters
        AssertionErrors.assertEquals("Pass", actual, expected)
    }

    @Test
    fun testOutputParameterMethodCreateFilm() {
        val expected = methodsFilm.find { it.name == "createFilm" }?.returnType
        val actual = parser.extractDataMethod(FilmController::class, "createFilm").outputParameter
        AssertionErrors.assertEquals("Pass", actual, expected)
    }

    @Test
    fun testPostAnnotationMethodCreateFilm() {
        val expected = methodFilmJavaClass.find { it.name == "createFilm" }
            ?.getAnnotation(PostMapping::class.java)
        val actual = parser.extractDataAnnotationPostMethod(
            FilmController::class,
            "createFilm",
            PostMapping::class.java
        ).annotation
        AssertionErrors.assertEquals("Pass", actual, expected)
    }

    @Test
    fun testDescriptionAnnotationMethodCreateFilm() {
        val expected = methodFilmJavaClass.find { it.name == "createFilm" }
            ?.getAnnotation(io.swagger.v3.oas.annotations.Operation::class.java)?.summary
        val actual = parser.extractDataAnnotationMethod(FilmController::class, "createFilm").description
        AssertionErrors.assertEquals("Pass", actual, expected)
    }

    @Test
    fun testPathAnnotationMethodCreateFilm() {
        val expected = methodFilmJavaClass.find { it.name == "createFilm" }
            ?.getAnnotation(PostMapping::class.java)?.path?.toList()
        val actual =
            parser.extractDataAnnotationPostMethod(FilmController::class, "createFilm", PostMapping::class.java).path
        AssertionErrors.assertEquals("Pass", actual, expected)
    }

    @Test
    fun testNameMethodChangeFilm() {
        val expected = FilmController::class.declaredMemberFunctions.find { it.name == "changeFilm" }?.name
        val actual = parser.extractDataMethod(FilmController::class, "changeFilm").name
        AssertionErrors.assertEquals("Pass", actual, expected)
    }

    @Test
    fun testInputParametersMethodChangeFilm() {
        val expected = methodsFilm.find { it.name == "changeFilm" }?.valueParameters
        val actual = parser.extractDataMethod(FilmController::class, "changeFilm").inputParameters
        AssertionErrors.assertEquals("Pass", actual, expected)
    }

    @Test
    fun testOutputParameterMethodChangeFilm() {
        val expected = methodsFilm.find { it.name == "changeFilm" }?.returnType
        val actual = parser.extractDataMethod(FilmController::class, "changeFilm").outputParameter
        AssertionErrors.assertEquals("Pass", actual, expected)
    }

    @Test
    fun testPutAnnotationMethodChangeFilm() {
        val expected = methodFilmJavaClass.find { it.name == "changeFilm" }
            ?.getAnnotation(PutMapping::class.java)
        val actual = parser.extractDataAnnotationPutMethod(
            FilmController::class,
            "changeFilm",
            PutMapping::class.java
        ).annotation
        AssertionErrors.assertEquals("Pass", actual, expected)
    }

    @Test
    fun testDescriptionAnnotationMethodChangeFilm() {
        val expected = methodFilmJavaClass.find { it.name == "changeFilm" }
            ?.getAnnotation(io.swagger.v3.oas.annotations.Operation::class.java)?.summary
        val actual = parser.extractDataAnnotationMethod(FilmController::class, "changeFilm").description
        AssertionErrors.assertEquals("Pass", actual, expected)
    }

}