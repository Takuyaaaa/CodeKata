package com.code_kata

import java.io.File

class Anagrams {
    companion object {
        /**
         * execute processes and print all anagrams
         */
        fun File.extractAllAnagrams(): List<List<String>> {
            return this.addUsedWordsInfo()
             // groupBy sorted string used for anagrams
             .groupBy { it.first }
             .allAnagrams()
        }

        /**
         * add words info as pair`s first element
         * i.e. (aaghmr, graham)
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
         * return all words which has its anagram in a list
         */
        private fun Map<String, List<Pair<String, String>>>.allAnagrams(): List<List<String>> {
            return this.toList()
                    // filter out words which does not have its anagram
                    .filter { it.second.count() > 1 }
                    // remove pair's first element which is used for counting
                    .map { it.second }
                    // extract words string date from pair
                    .map { it.extractWords() }
        }

        /**
         * extract words string date from pair
         */
        private fun List<Pair<String, String>>.extractWords(): List<String> {
            return this.map {
                it.second
            }
        }
    }
}