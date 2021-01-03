package com.code_kata.code_kata

import java.io.File

class Anagrams {
    companion object {
        /**
         * execute processes and print all anagrams
         */
        fun File.extractAllAnagrams(): List<List<String>> {
            return this.readLines()
                    .groupBy { it.sortAlphabetically() }
                    .filterValues { it.count() > 1 }
                    .map { it.value }
        }

        /**
         * sort string alphabetically
         */
        private fun String.sortAlphabetically(): String {
            return this.toCharArray().sorted().joinToString("")
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