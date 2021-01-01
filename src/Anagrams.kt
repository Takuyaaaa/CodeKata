package com.code_kata

import java.io.File

class Anagrams {
    companion object {
        /**
         * execute processes and print the most repeated anagrams
         */
        fun File.printMostRepeatedAnagram() {
            this.addUsedWordsInfo()
             // groupBy sorted string used for anagrams
             .groupBy { it.first }
             .pickMostRepeatedAnagram()
             // print the most repeated anagrams by referring second element of each Pair
             .forEach {
                 println(it.second)
             }
        }

        /**
         * make pair: first is sorted string used for an anagram, second is raw string data
         */
        private fun File.addUsedWordsInfo(): List<Pair<String, String>> {
            return this.readLines()
                    .map {
                        val sortedString = it.sort()
                        Pair(sortedString, it)
                    }
        }

        /**
         * sort string alphabetically
         */
        private fun String.sort(): String {
            return this.toCharArray().sorted().joinToString("")
        }

        /**
         * return words categorised into the most repeated anagram
         */
        private fun Map<String, List<Pair<String, String>>>.pickMostRepeatedAnagram(): List<Pair<String, String>> {
            return this.toList().sortedByDescending { it.second.count() }[0].second
        }
    }
}