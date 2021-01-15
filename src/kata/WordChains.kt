package com.code_kata.kata

import java.io.File

class WordChains(val start: String, val end: String) {
    private val words_list = File("resources/wordlist_10000_MIT.txt").readLines()

    fun process() {
        val candidateWords = words_list
                .asSequence()
                .filter { it.length == start.length }
                .filter { it != start }
                .map { it.toList() }
                .toList()

        val markedWords = candidateWords
                .asSequence()
                .map { it.oneCharDiff(start.toList()) }
                .map { it.getByKey(false).count() }
                .mapIndexed { index, count ->
                    if (count == 1) return@mapIndexed index
                    return@mapIndexed -1
                }
                .toList()

        val targetIndex = markedWords.find { it != -1 }

        // todo: not using !!
        println(candidateWords[targetIndex!!].joinToString(""))
    }
}

fun List<Char>.oneCharDiff(other: List<Char>): Map<Boolean, List<Boolean>> {
    return this.mapIndexed { index, char ->
        char == other[index]
    }.groupBy { it }
}

fun <T> Map<T, List<T>>.getByKey(key: T): List<T> {
    return this[key] ?: throw IllegalArgumentException("Invalid key passed: $key")
}