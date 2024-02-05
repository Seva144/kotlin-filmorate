package com.example.javafilmoratekotlin.parsing

class ControllerParsing {

    private val methodsControllerClass = mutableMapOf<String, Any?>()
    private val methodsControllerClassClear = ArrayList<Any?>()
    fun getMethod(classes: Set<Class<*>>): ArrayList<Any?> {
        for (controller in classes) {
            methodsControllerClass[controller.simpleName] = controller.declaredMethods.toList()
        }
        parseMethods(methodsControllerClass)
        return methodsControllerClassClear
    }


    private fun parseMethods(
        draftMethods: MutableMap<String, Any?>
    ) {
        for (methods in draftMethods) {
            val methodsClass = mutableMapOf<String, Any?>()
            val name = methods.key
            val listMethodsClear = ArrayList<String>()
            val listMethodsDraft = methods.value.toString()
                .replace("[", "")
                .replace("]", "")
            val partOne = listMethodsDraft.split(", ")
            for (part in partOne) {
                val method = ArrayList<String>()
                val partTwo = part.split(" ")
                //имя метода
                val partFive = partTwo[2].substringBeforeLast("(")
                val partSix = partFive.split(".")
                val partSix1 = partSix[partSix.size - 1]
                method.add("Name : $partSix1")
                //идентификатор доступа
                val partFour = partTwo[0]
                method.add("Access: $partFour")

                //параметры на входе
                val partSeven = partTwo[2].substringAfterLast("(").replace(")", "")
                val partEight = partSeven.split(",")

                if (partSeven == "") {
                    method.add("input: null")
                } else {
                    val inputParameters = ArrayList<String>()
                    for (par in partEight) {
                        val p = par.split(".")
                        inputParameters.add(p[p.size - 1])
                    }
                    method.add("input : ${inputParameters.toString()
                        .replace("[", "")
                        .replace("]", "")}")
                }
                //возвращаемый параметр
                val partThree = partTwo[1].split(".")
                val partThree1 = partThree[partThree.size - 1]
                method.add("Output : $partThree1")
                listMethodsClear.add(method.toString())
            }
            methodsClass[name] = listMethodsClear
            methodsControllerClassClear.add(methodsClass)
        }
    }
}