package com.code_kata.code_kata

import java.io.File

class Anagrams {
    companion object {
        /**
         * execute processes and print all anagrams
         */
        fun File.extractAllAnagrams() =
            this.useLines { lines: Sequence<String> ->
                lines.groupBy { it.sortAlphabetically() }
                        .asSequence()
                        .filter { it.value.count() > 1 }
                        .map { it.value }

            }

        /**
         * sort string alphabetically
         */
        private fun String.sortAlphabetically(): String =
            this.toCharArray().sorted().joinToString("")
    }
}