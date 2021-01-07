package com.code_kata.kata

class Trigram(sentence: String) {
    var sentenceList: List<String> = sentence.split(" ")

    fun generateWordMap(): Map<String, List<String>> =
        sentenceList.dropLast(2)
                .mapIndexed { index, it -> listOf(it, sentenceList[index + 1], sentenceList[index + 2]) }
                .groupBy ({ "${it[0]} ${it[1]}" }, {it[2]})

    fun getFirstTwoWords(): MutableList<String> =
            sentenceList.slice(0..1).toMutableList()

    // 引きずり出さないでクラス内で処理
    companion object {
        fun List<String>.getLastTwoWords(): String =
                "${this[this.lastIndex - 1]} ${this[this.lastIndex]}"

        fun Map<String, List<String>>.getNextWord(key: String): String =
                this[key]?.elementAt(0) ?: "NA"
    }


}