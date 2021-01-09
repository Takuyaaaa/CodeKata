package com.code_kata.kata

class Trigram(sentence: String) {
    private var sentenceList: List<String> = sentence.split(" ")
    private val wordMap: Map<String, List<String>> = generateWordMap()
    private var generatedSentence: MutableList<String> = getFirstTwoWords()

    private fun generateWordMap(): Map<String, List<String>> =
        sentenceList.dropLast(2)
                .mapIndexed { index, it -> listOf(it, sentenceList[index + 1], sentenceList[index + 2]) }
                .groupBy ({ "${it[0]} ${it[1]}" }, {it[2]})

    fun execute(times: Int) {
        var count = 0

        while (count < times) {
            try {
                val nextWord = getNextWord(getLastTwoWords())
                generatedSentence.add(nextWord)
                count ++
            } catch (e: IllegalArgumentException) {
                generatedSentence.removeLast()
                count --
                continue
            }
        }
    }

    private fun getFirstTwoWords(): MutableList<String> =
            sentenceList.slice(0..1).toMutableList()

    private fun getLastTwoWords(): String =
            "${generatedSentence[generatedSentence.lastIndex - 1]} ${generatedSentence[generatedSentence.lastIndex]}"

    private fun getNextWord(key: String): String {
        val wordOption = wordMap.getByKey(key)
        val randomIndex = (0..wordOption.lastIndex).random()
        return wordOption.elementAt(randomIndex)
    }

    fun joinToStringBySpace(): String =
            generatedSentence.joinToString(" ")

    companion object {
        /**
         * get value by key assuring return type is "List<String>", not "List<String>?"
         */
        private fun Map<String, List<String>>.getByKey(key: String): List<String> {
            return this[key] ?: throw IllegalArgumentException("invalid item passed: $key")
        }
    }
}