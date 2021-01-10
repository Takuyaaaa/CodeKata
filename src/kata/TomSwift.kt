package com.code_kata.kata

class Trigram(sentence: String) {
    // storing sentence passed as argument as List
    private var sentenceList: List<String> = sentence.split(" ")
    // storing word relationship as Map i.e. {I wish=[I, I], wish I=[may, might], I may=[I], may I=[wish]}
    // above map is saying "the two words 'wish I' is followed by the words 'may, might' in the sentence"
    private val wordMap: Map<String, List<String>> = generateWordMap()
    // sentence generated with trigram algorithm
    private var generatedSentence: MutableList<String> = getFirstTwoWords()

    /**
     * generate wordMap which stores word relationship
     */
    private fun generateWordMap(): Map<String, List<String>> =
        sentenceList.dropLast(2)
                .mapIndexed { index, it -> listOf(it, sentenceList[index + 1], sentenceList[index + 2]) }
                .groupBy ({ "${it[0]} ${it[1]}" }, {it[2]})

    /**
     * execute trigram algorithm repeatedly until sentence size reaches "length"
     */
    fun execute(length: Int) {
        while (generatedSentence.size < length) {
            try {
                // when the nextWord has valid word option to be followed,
                // pick that word and add that word to "generatedSentence"
                val nextWord = getNextWord(getLastTwoWords())
                generatedSentence.add(nextWord)
            } catch (e: IllegalArgumentException) {
                // when the nextWord doesn't have valid word option to be followed,
                // rollback "generatedSentence" to one step before and undo one count
                generatedSentence.removeLast()
                continue
            }
        }

        // print the result of trigram algorithm processing
        println(generatedSentence.joinToString(" "))
    }

    /**
     * randomly get first two words which will be origin of trigram algorithm
     */
    private fun getFirstTwoWords(): MutableList<String> {
        val startIndex = (0 until sentenceList.lastIndex).random()
        return sentenceList.slice(startIndex..startIndex + 1).toMutableList()
    }

    /**
     * get last two words of "generatedSentence" to pick a next word following
     */
    private fun getLastTwoWords(): String =
            "${generatedSentence[generatedSentence.lastIndex - 1]} ${generatedSentence[generatedSentence.lastIndex]}"

    /**
     * get a next word by referring last two words passed as argument "key"
     */
    private fun getNextWord(key: String): String {
        val wordOption = wordMap.getByKey(key)
        val randomIndex = (0..wordOption.lastIndex).random()
        return wordOption.elementAt(randomIndex)
    }

    companion object {
        /**
         * get value by key assuring return type is "List<String>", not "List<String>?"
         */
        private fun Map<String, List<String>>.getByKey(key: String): List<String> {
            return this[key] ?: throw IllegalArgumentException("invalid item passed: $key")
        }
    }
}