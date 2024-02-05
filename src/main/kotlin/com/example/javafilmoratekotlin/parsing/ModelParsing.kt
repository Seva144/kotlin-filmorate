package com.example.javafilmoratekotlin.parsing

class ModelParsing {

    private val constructorDataClass = mutableMapOf<String, Any?>()
    private val constructorDataClassClear = ArrayList<Any?>()

    /*получение конструктора*/
    fun getConstructor(classes: Set<Class<*>>): ArrayList<Any?> {
        for (data in classes) {
            constructorDataClass[data.simpleName] = data.declaredFields.toList()
        }
        parseConstructor(constructorDataClass)
        return constructorDataClassClear
    }

    /*парсинг конструктора*/
    private fun parseConstructor(
        draftConstructor: MutableMap<String, Any?>
    ) {
        for (con in draftConstructor) {
            val constructClass = mutableMapOf<String, Any?>()
            val name = con.key
            val listConstructorClear = ArrayList<String>()
            val listConstructorDraft = con.value.toString()
                .replace("[", "")
                .replace("]", "")
            val partOne = listConstructorDraft.split(", ")
            for (part in partOne) {
                val partTwo = part.split(" ")
                val partThree = partTwo[2].split(".")
                val partFour = partTwo[1].split(".")
                listConstructorClear.add(partThree[partThree.size - 1] + " : " + partFour[partFour.size - 1])
            }
            constructClass[name] = listConstructorClear
            constructorDataClassClear.add(constructClass)
        }
    }
}