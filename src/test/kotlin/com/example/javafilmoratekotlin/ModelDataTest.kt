package com.example.javafilmoratekotlin

import com.example.javafilmoratekotlin.model.Film
import com.example.javafilmoratekotlin.parsing.ClassParser
import com.example.javafilmoratekotlin.util.EasyRandomUtils.easyRandom
import io.swagger.v3.oas.annotations.media.Schema
import org.junit.jupiter.api.Test
import org.springframework.test.util.AssertionErrors.assertEquals
import kotlin.reflect.full.findAnnotations


class ModelDataTest {

    private val parser = ClassParser()

    @Test
    fun testName() {
        val expected = Film::class.java.simpleName
        val actual = parser.extractData(Film::class).simpleName
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testPackages() {
        val expected = Film::class.java.packageName
        val actual = parser.extractData(Film::class).pkg
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testPrimitiveConstructor() {
        val expected = Film::class.java.constructors
        val actual = parser.extractData(Film::class).primitiveConstructor
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testNestedFields() {
        val expected = Film::class.java.declaredFields
        val actual = parser.extractData(Film::class).nestedFields
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testAnnotationClass() {
        val schemaAnnotation = Film::class.findAnnotations(Schema::class)
        val expected = schemaAnnotation[0].description
        val actual = parser.extractDataAnnotationClass(Film::class).description
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testNameFieldId() {
        val expected = Film::class.java.declaredFields[0].name
        val actual = parser.extractDataFiled(Film::class.java, 0).name
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testTypeFieldId() {
        val expected = Film::class.java.declaredFields[0].type.toString()
        val actual = parser.extractDataFiled(Film::class.java, 0).type
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testDescriptionFieldId() {
        val schemaAnnotation = Film::class.java.declaredFields[0]
        val expected = schemaAnnotation?.getAnnotation(Schema::class.java)?.description
        val actual = parser.extractDataFiled(Film::class.java, 0).description
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testExampleFieldId() {
        val exampleObject = easyRandom.objects(Film::class.java, 1).toList().first()
        val expected = exampleObject.id
        val actual = parser.extractDataFiled(exampleObject.javaClass, 0).example
        println(actual)

    }

    @Test
    fun testNullableFieldId() {
        val schemaAnnotation = Film::class.java.declaredFields[0]
        val expected = schemaAnnotation?.getAnnotation(Schema::class.java)?.nullable
        val actual = parser.extractDataFiled(Film::class.java, 0).nullable
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testNameFieldName() {
        val expected = Film::class.java.declaredFields[1].name
        val actual = parser.extractDataFiled(Film::class.java, 1).name
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testTypeFieldName() {
        val expected = Film::class.java.declaredFields[1].type.toString()
        val actual = parser.extractDataFiled(Film::class.java, 1).type
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testDescriptionFieldName() {
        val schemaAnnotation = Film::class.java.declaredFields[1]
        val expected = schemaAnnotation?.getAnnotation(Schema::class.java)?.description
        val actual = parser.extractDataFiled(Film::class.java, 1).description
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testExampleFieldName() {
    }

    @Test
    fun testNullableFieldName() {
        val schemaAnnotation = Film::class.java.declaredFields[1]
        val expected = schemaAnnotation?.getAnnotation(Schema::class.java)?.nullable
        val actual = parser.extractDataFiled(Film::class.java, 1).nullable
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testNameFieldReleaseDate() {
        val expected = Film::class.java.declaredFields[2].name
        val actual = parser.extractDataFiled(Film::class.java, 2).name
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testTypeFieldReleaseDate() {
        val expected = Film::class.java.declaredFields[2].type.toString()
        val actual = parser.extractDataFiled(Film::class.java, 2).type
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testDescriptionFieldReleaseDate() {
        val schemaAnnotation = Film::class.java.declaredFields[2]
        val expected = schemaAnnotation?.getAnnotation(Schema::class.java)?.description
        val actual = parser.extractDataFiled(Film::class.java, 2).description
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testExampleFieldReleaseDate() {
    }

    @Test
    fun testNullableFieldReleaseDate() {
        val schemaAnnotation = Film::class.java.declaredFields[2]
        val expected = schemaAnnotation?.getAnnotation(Schema::class.java)?.nullable
        val actual = parser.extractDataFiled(Film::class.java, 2).nullable
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testNameFieldReleaseDuration() {
        val expected = Film::class.java.declaredFields[3].name
        val actual = parser.extractDataFiled(Film::class.java, 3).name
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testTypeFieldReleaseDuration() {
        val expected = Film::class.java.declaredFields[3].type.toString()
        val actual = parser.extractDataFiled(Film::class.java, 3).type
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testDescriptionFieldDuration() {
        val schemaAnnotation = Film::class.java.declaredFields[3]
        val expected = schemaAnnotation?.getAnnotation(Schema::class.java)?.description
        val actual = parser.extractDataFiled(Film::class.java, 3).description
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testExampleFieldDuration() {
    }

    @Test
    fun testNullableFieldDuration() {
        val schemaAnnotation = Film::class.java.declaredFields[3]
        val expected = schemaAnnotation?.getAnnotation(Schema::class.java)?.nullable
        val actual = parser.extractDataFiled(Film::class.java, 3).nullable
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testNameFieldTags() {
        val expected = Film::class.java.declaredFields[4].name
        val actual = parser.extractDataFiled(Film::class.java, 4).name
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testTypeFieldTags() {
        val expected = Film::class.java.declaredFields[4].type.toString()
        val actual = parser.extractDataFiled(Film::class.java, 4).type
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testDescriptionTags() {
        val schemaAnnotation = Film::class.java.declaredFields[4]
        val expected = schemaAnnotation?.getAnnotation(Schema::class.java)?.description
        val actual = parser.extractDataFiled(Film::class.java, 4).description
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testExampleTags() {
    }

    @Test
    fun testNullableTags() {
        val schemaAnnotation = Film::class.java.declaredFields[4]
        val expected = schemaAnnotation?.getAnnotation(Schema::class.java)?.nullable
        val actual = parser.extractDataFiled(Film::class.java, 4).nullable
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testNameFieldUsers() {
        val expected = Film::class.java.declaredFields[5].name
        val actual = parser.extractDataFiled(Film::class.java, 5).name
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testTypeFieldUsers() {
        val expected = Film::class.java.declaredFields[5].type.toString()
        val actual = parser.extractDataFiled(Film::class.java, 5).type
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testDescriptionUsers() {
        val schemaAnnotation = Film::class.java.declaredFields[5]
        val expected = schemaAnnotation?.getAnnotation(Schema::class.java)?.description
        val actual = parser.extractDataFiled(Film::class.java, 5).description
        assertEquals("Pass", expected, actual)
    }

    @Test
    fun testExampleUsers() {
    }

    @Test
    fun testNullableUsers() {
        val schemaAnnotation = Film::class.java.declaredFields[5]
        val expected = schemaAnnotation?.getAnnotation(Schema::class.java)?.nullable
        val actual = parser.extractDataFiled(Film::class.java, 5).nullable
        assertEquals("Pass", expected, actual)
    }
}