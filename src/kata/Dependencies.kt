package com.code_kata.kata

class Dependencies {
    private val directDependencies = mutableMapOf<String, MutableList<String>>()
    private val dependencyResult = mutableMapOf<String, MutableList<String>>()

    fun addDirect(file: String, dependencies: MutableList<String>) {
        directDependencies[file] = dependencies
    }

    private fun checkDependencies() {
        val map = mutableMapOf<String, MutableList<String>>()
        directDependencies
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
    }

    private fun processCheck(file: String, list: MutableList<String>) {
        try {
            directDependencies.getByKey(file).forEach {
                list.add(it)
                processCheck(it, list)
            }
        } catch (e: IllegalArgumentException) {
            // do nothing
        }
    }

    fun dependenciesFor(file: String): List<String> {
        checkDependencies()
        return dependencyResult.getByKey(file)
    }

    companion object {
        /**
         * get value by key assuring return type is "List<String>", not "List<String>?"
         */
        private fun MutableMap<String, MutableList<String>>.getByKey(key: String): List<String> {
            return this[key] ?: throw IllegalArgumentException("invalid item passed: $key")
        }
    }

}