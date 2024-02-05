package com.example.javafilmoratekotlin.parsing

import com.example.javafilmoratekotlin.controllers.*
import com.example.javafilmoratekotlin.model.User
import java.time.Instant
import kotlin.reflect.*
import kotlin.reflect.full.*


class Persona(surname: String, age: Int) {

    private val id: Int = 0
    private val name: String = ""

    fun personaWords() {
        println("My name is $name")
    }

    fun personaPlayGame(game: String, console: String) {
        println("Persona plays in $game on $console")
    }

}

fun main() {

    val uniques = mutableMapOf<Class<*>, Boolean>()
    val controllerClass = FilmController::class
    val dataClass = User::class
    val person = Persona("Esmeralda", 23)


    displayClassName(person)

}

/*Для определения имени класса*/
fun displayClassName(value: Any) {
    val simpleClass = value::class
    val name = simpleClass.simpleName
    println(name)
}

/*Для определения методов*/
fun displayFunction(value: Any) {
    value::class.declaredFunctions
        .map { p -> " * ${p.name}" }
        .forEach(::println)
}

/*Для определения полей*/
fun displayFields(value: Any) {
    value::class.declaredMemberProperties
        .map { p -> " * ${p.name}" }
        .forEach(::println)
}

/*Для определения конструктора (не датакласса)*/
fun displayConstructionDataClass(value: Any) {
    val clazz = value::class
    val constructor = clazz.primaryConstructor!!
    val listConstructor: List<String> = constructor.parameters.map { p ->
        " ${p.name} : ${p.type}"
    }
    println(listConstructor)
}

/*Для определения полей методов*/

fun callWithFakeArgs(callable: KCallable<*>) {
    val arguments = callable.parameters
        .filterNot { it.isOptional }
        .associateWith { fakeValueFor(it) }
    callable.callBy(arguments)
}

fun fakeValueFor(parameter: KParameter) =
    when (parameter.type) {
        typeOf<String>() -> "Fake ${parameter.name}"
        typeOf<Int>() -> 123
        else -> error("Unsupported type")
    }

data class SimpleClass(val int: Int, val string: String, val instant: Instant)

fun testCreateByConstructorByParamsArray(dataClass: ClassLoader) {
    val paramsData = arrayOf(1234, "test", Instant.now())

    val clazz = SimpleClass::class
    println(clazz.primaryConstructor!!.toString())
}