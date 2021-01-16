package com.code_kata.kata

import java.io.File

class WordChains(private val start: String, private val end: String) {
    // word list referred when executing word chains algorithm
    private val wordList = File("resources/wordlist_for_word_chains.txt").readLines()
    // list storing words calculated by word chains algorithm
    val wordResult = mutableListOf<String>()

    /**
     * execute word chains algorithm
     */
    fun executeWordChains() {
        // word list one of which is possibly next word
        val wordOptions = extractWordOptions()
        searchNextWord(wordOptions, start)
    }

    /**
     * extract word options from "wordList" which are possible next word
     */
    private fun extractWordOptions(): MutableList<List<Char>> =
        wordList.asSequence()
                .filter { it.length == start.length }
                .filter { it != start }
                .map { it.toList() }
                .toMutableList()

    /**
     * calculate a next word which has one character diff from "baseWord"
     */
    private fun searchNextWord(wordOptions: MutableList<List<Char>>, baseWord: String) {
        // record "baseWord" to record history of word chains algorithm
        wordResult.add(baseWord)
        val examinedList = examineWordOptions(wordOptions, baseWord)
        // get index pointing to next word
        val nextIndex = examinedList.getTargetIndex()
        val nextWord = wordOptions[nextIndex].joinToString("")

        // remove word picked as next word to continue processing recursively
        wordOptions.removeAt(nextIndex)
        when (nextWord) {
            // when "targetWord" is matched to "end", finish recursive calling
            end -> wordResult.add(nextWord)
            else -> searchNextWord(wordOptions, nextWord)
        }
    }

    /**
     * examine "wordOptions" and record which one has one character diff from "baseWord"
     */
    val ONLY_ONE_CHAR_DIFF = 1
    val NOT_NEXT_WORD = -1
    private fun examineWordOptions(wordOptions: MutableList<List<Char>>, baseWord: String): List<Int> =
            wordOptions
                    .asSequence()
                    // map each character diff to each word
                    .map { it.groupByCharDiff(baseWord.toList()) }
                    // map how many characters are NOT in common with "wordOptions"
                    .map { it.getByKey(false).count() }
                    .mapIndexed { index, count ->
                        return@mapIndexed when (count) {
                            // when the word's character has only one char diff
                            // against to "baseWord", map its index as value
                            ONLY_ONE_CHAR_DIFF -> index
                            // when the word's character has more than one char diff
                            // against to "baseWord", map "NOT_NEXT_WORD(-1)" as value
                            else -> NOT_NEXT_WORD
                        }
                    }
                    .toList()
}

/**
 * groupBy each character diff against "other"
 */
fun List<Char>.groupByCharDiff(other: List<Char>): Map<Boolean, List<Boolean>> {
    return this.mapIndexed { index, char ->
        char == other[index]
    }.groupBy { it }
}

/**
 * get element by "key"
 */
fun <T> Map<T, List<T>>.getByKey(key: T): List<T> =
    this[key] ?: throw IllegalArgumentException("Invalid key passed: $key")

/**
 * get targetIndex whose value is not equal to -1
 */
fun List<Int>.getTargetIndex(): Int =
        this.find { it != -1 } ?: throw NullPointerException("no match!")