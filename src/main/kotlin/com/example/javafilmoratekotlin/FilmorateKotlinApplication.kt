package com.example.javafilmoratekotlin

import com.example.javafilmoratekotlin.model.Film
import com.example.javafilmoratekotlin.parsing.ControllerParsing
import com.example.javafilmoratekotlin.parsing.ModelParsing
import io.swagger.v3.oas.annotations.media.Schema
import nonapi.io.github.classgraph.json.Id
import org.hibernate.validator.internal.properties.Field
import org.reflections.Reflections
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Description
import org.springframework.web.bind.annotation.RestController
import kotlin.reflect.KProperty
import kotlin.reflect.full.*


/**
 * Приложение рейтинга фильмов
 *
 * @author Artyom Sevostyanov
 */
@SpringBootApplication
class FilmorateKotlinApplication

/**
 * @suppress
 */
fun main(args: Array<String>) {
    runApplication<FilmorateKotlinApplication>(*args)

    val module: String = "com.example"
    val reflections = Reflections(module)

    val dataClasses = reflections.getTypesAnnotatedWith(Schema::class.java)
    val controllerClass = reflections.getTypesAnnotatedWith(RestController::class.java)

    println(ModelParsing().getConstructor(dataClasses))
    println(ControllerParsing().getMethod(controllerClass))
}








