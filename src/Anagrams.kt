package com.code_kata

import java.io.File

class Anagrams {
    companion object {
        /**
         * execute processes and print the most repeated anagrams
         */
        fun File.printAllAnagrams() {
            this.addUsedWordsInfo()
             // groupBy sorted string used for anagrams
             .groupBy { it.first }
             .allAnagrams()
             // print the most repeated anagrams by referring second element of each Pair
             .forEach { anagramList ->
                 val wordList = anagramList.map { anagramPair ->
                     anagramPair.second
                 }
                 println(wordList)
             }
        }

        /**
         * add words info as pair`s first element
         */
        private fun File.addUsedWordsInfo(): List<Pair<String, String>> {
            return this.readLines()
                    .map {
                        val sortedString = it.sortAlphabetically()
                        Pair(sortedString, it)
                    }
        }

        /**
         * sort string alphabetically
         */
        private fun String.sortAlphabetically(): String {
            return this.toCharArray().sorted().joinToString("")
        }

        /**
         * return words which has its anagram in a list
         */
        private fun Map<String, List<Pair<String, String>>>.allAnagrams(): List<List<Pair<String, String>>> {
            return this.toList()
                    .filter { it.second.count() > 1 }
                    .map { it.second }
        }
    }
}