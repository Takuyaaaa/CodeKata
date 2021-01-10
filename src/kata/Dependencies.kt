package com.code_kata.kata

class Dependencies {
    val dependencyMap = mutableMapOf<String, List<String>>()
    val dependencyResult = mutableMapOf<String, MutableList<String>>()

    fun addDirect(file: String, dependencies: List<String>) {
        dependencyMap[file] = dependencies
    }

    fun processCheck(file: String, list: MutableList<String>) {
        try {
            val deps = dependencyMap.getByKey(file)
            deps.forEach {
                list.add(it)
                processCheck(it, list)
            }
        } catch (e: IllegalArgumentException) {

        }
    }

    fun checkDependencies() {
        val map = mutableMapOf<String, MutableList<String>>()
        dependencyMap
                .forEach {
                    val list = mutableListOf<String>()
                    processCheck(it.key, list)
                    map[it.key] = list
                }
        map.forEach {
            val values = it.value.toSet().toMutableList()
            values.sort()
            dependencyResult[it.key] = values
        }
        println(dependencyResult)
    }

    companion object {
        /**
         * get value by key assuring return type is "List<String>", not "List<String>?"
         */
        private fun MutableMap<String, List<String>>.getByKey(key: String): List<String> {
            return this[key] ?: throw IllegalArgumentException("invalid item passed: $key")
        }
    }

}