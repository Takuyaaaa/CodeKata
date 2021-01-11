package com.code_kata.kata

import java.lang.IllegalStateException

class Dependencies {
    // map storing direct dependencies relationships
    private val directDependencies = mutableMapOf<String, MutableList<String>>()
    // map storing all dependencies including transitive ones
    private val allDependencies = mutableMapOf<String, MutableList<String>>()

    /**
     * add direct dependencies info to "directDependencies"
     */
    fun addDirect(file: String, dependencies: MutableList<String>) {
        directDependencies[file] = dependencies
    }

    /**
     * by referring "directDependencies", check all dependencies
     * including transitive ones and store them to "allDependencies"
     */
    private fun checkDependencies() {
        val tempMap = mutableMapOf<String, MutableList<String>>()
        // check "directDependencies" and record all dependencies info to "tempMap"
        directDependencies
                .forEach {
                    val list = mutableListOf<String>()
                    executeCheck(it.key, list)
                    tempMap[it.key] = list
                }
        // by referring "tempMap", non-duplicated and sorted dependencies info
        // is recorded to "allDependencies"
        tempMap.recordNonDuplicatedAndSortedInfo(allDependencies)
    }

    /**
     * execute dependencies check process recursively
     */
    private fun executeCheck(file: String, list: MutableList<String>) {
        try {
            directDependencies.getByKey(file).forEach {
                if (list.isCircular(it))
                    throw IllegalStateException("Circular dependencies detected for the file; $file")
                list.add(it)
                executeCheck(it, list)
            }
        } catch (e: IllegalArgumentException) {
            // when "IllegalArgumentException" occur, that means passed "file"
            // doesn't have any dependencies info on "directDependencies",
            // so we do nothing for that case but finishing recursive method call
        } catch (e: IllegalStateException) {
            // when "IllegalStateException" occur, that means passed "file" must have
            // circular dependencies as relationships, so we do nothing for that case
            // but finishing recursive method call

        }
    }

    /**
     * check all dependencies and return files depended by passed "file"
     */
    fun dependenciesFor(file: String): List<String> {
        checkDependencies()
        return allDependencies.getByKey(file)
    }

    companion object {
        /**
         * if dependencies relationship is being circular or not
         */
        private fun MutableList<String>.isCircular(file: String): Boolean =
                this.contains(file)

        /**
         * get value by key assuring return type is "List<String>", not "List<String>?"
         */
        private fun MutableMap<String, MutableList<String>>.getByKey(key: String): List<String> {
            return this[key] ?: throw IllegalArgumentException("invalid item passed: $key")
        }

        /**
         * record info of "this" to passed "dependenciesMap" in non-duplicated and sorted form
         */
        private fun MutableMap<String, MutableList<String>>.recordNonDuplicatedAndSortedInfo(
                dependenciesMap: MutableMap<String, MutableList<String>>) {
            this.forEach {
                val values = it.value.toSet().toMutableList()
                values.sort()
                dependenciesMap[it.key] = values
            }
        }
    }
}