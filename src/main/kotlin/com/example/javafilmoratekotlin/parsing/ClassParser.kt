package com.example.javafilmoratekotlin.parsing

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import java.lang.reflect.Constructor
import java.lang.reflect.Field
import kotlin.reflect.KClass
import kotlin.reflect.KParameter
import kotlin.reflect.KProperty1
import kotlin.reflect.KType
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.findAnnotations
import kotlin.reflect.full.valueParameters

@Component
class ClassParser {
    @Suppress("UNCHECKED_CAST")
    fun <R> readInstanceProperty(instance: Any, propertyName: String): R {
        val property = instance::class.declaredMemberProperties
            .first { it.name == propertyName } as KProperty1<Any, *>
        return property.get(instance) as R
    }

    fun extractData(clazz: KClass<*>): ObjectViewClass {
        return ObjectViewClass(
            simpleName = clazz.simpleName.toString(),
            pkg = clazz.java.packageName,
            primitiveConstructor = clazz.java.constructors,
            nestedFields = clazz.java.declaredFields,
        )
    }

    fun extractDataAnnotationClass(clazz: KClass<*>): ObjectViewAnnotationClass {
        return ObjectViewAnnotationClass(
            description = clazz.findAnnotations(Schema::class)[0].description
        )

    }

    fun extractDataFiled(clazz: Class<*>, number: Int): ObjectViewField {
        val fields = clazz.declaredFields
        return ObjectViewField(
            name = fields[number].name,
            type = fields[number].type.toString(),
            description = fields[number].getAnnotation(Schema::class.java).description,
            example = "",
//            example = clazz.getDeclaredField(fields[number].name).let { field ->
//                field.isAccessible = true
//                return@let field.get(this)
//            },
            nullable = fields[number].getAnnotation(Schema::class.java).nullable
        )
    }

    fun extractDataMethod(clazz: KClass<*>, name: String): ObjectViewMethod {
        return ObjectViewMethod(
            name = clazz.declaredMemberFunctions.find { it.name == name }?.name,
            inputParameters = clazz.declaredMemberFunctions.find { it.name == name }?.valueParameters,
            outputParameter = clazz.declaredMemberFunctions.find { it.name == name }?.returnType,
        )
    }

    fun extractDataAnnotationPostMethod(
        clazz: KClass<*>,
        name: String,
        post: Class<PostMapping>
    ): ObjectViewCRUDAnnotation {
        return ObjectViewCRUDAnnotation(
            annotation = clazz.java.declaredMethods.find { it.name == name }?.getAnnotation(post),
            path = clazz.java.declaredMethods.find { it.name == "createFilm" }
                ?.getAnnotation(post)?.path?.toList()
        )
    }

    fun extractDataAnnotationGetMethod(
        clazz: KClass<*>,
        name: String,
        get: Class<GetMapping>
    ): ObjectViewCRUDAnnotation {
        return ObjectViewCRUDAnnotation(
            annotation = clazz.java.declaredMethods.find { it.name == name }?.getAnnotation(get),
            path = clazz.java.declaredMethods.find { it.name == "createFilm" }
                ?.getAnnotation(get)?.path?.toList()
        )
    }

    fun extractDataAnnotationPutMethod(
        clazz: KClass<*>,
        name: String,
        put: Class<PutMapping>
    ): ObjectViewCRUDAnnotation {
        return ObjectViewCRUDAnnotation(
            annotation = clazz.java.declaredMethods.find { it.name == name }?.getAnnotation(put),
            path = clazz.java.declaredMethods.find { it.name == "createFilm" }
                ?.getAnnotation(put)?.path?.toList()
        )
    }

    fun extractDataAnnotationMethod(clazz: KClass<*>, name: String): ObjectViewAnnotationMethod {
        return ObjectViewAnnotationMethod(
            description = clazz.java.declaredMethods.find { it.name == name }
                ?.getAnnotation(Operation::class.java)?.summary,

            )
    }
}

data class ObjectViewClass(
    val simpleName: String,
    val pkg: String,
    val primitiveConstructor: Array<Constructor<*>>,
    val nestedFields: Array<Field>
)

data class ObjectViewAnnotationClass(
    val description: String
)

data class ObjectViewField(
    val name: String,
    val type: String,
    val description: String,
    val example: String,
    val nullable: Boolean,
)

data class ObjectViewMethod(
    val name: String?,
    val inputParameters: List<KParameter>?,
    val outputParameter: KType?
)

data class ObjectViewCRUDAnnotation(
    val annotation: Annotation?,
    val path: List<String>?
)

data class ObjectViewAnnotationMethod(
    val description: String?
)