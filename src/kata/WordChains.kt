package com.code_kata.kata

import java.io.File

class WordChains(private val start: String, private val end: String) {
    private val wordList = File("resources/wordlist_for_word_chains.txt").readLines()

    fun executeWordChains() {
        val wordOptions = wordList
                .asSequence()
                .filter { it.length == start.length }
                .filter { it != start }
                .map { it.toList() }
                .toMutableList()

        searchNextWord(wordOptions, start)
    }

    private fun searchNextWord(wordOptions: MutableList<List<Char>>, baseWord: String) {
        println(baseWord)
        val markedWords = wordOptions
                .asSequence()
                .map { it.oneCharDiff(baseWord.toList()) }
                .map { it.getByKey(false).count() }
                .mapIndexed { index, count ->
                    if (count == 1) return@mapIndexed index
                    return@mapIndexed -1
                }
                .toList()


        val targetIndex = markedWords.find { it != -1 } ?: throw NullPointerException("no match!")
        val targetWord = wordOptions[targetIndex].joinToString("")

        wordOptions.removeAt(targetIndex)
        when (targetWord) {
            end -> println(targetWord)
            else -> searchNextWord(wordOptions, targetWord)
        }
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