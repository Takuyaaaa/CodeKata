package com.code_kata.code_kata

import java.io.File

class CountingCodeLines {
    companion object {
        fun File.countCodeLines(): Int {
            return readLines()
                    .excludeMultipleLinesComment()
                    .excludeOneLineComment()
                    .count()
        }

        private fun List<String>.excludeOneLineComment(): List<String> {
            return this.filter {
                it.split("//")[0].isNotBlank()
            }
        }

        private fun List<String>.excludeMultipleLinesComment(): List<String> {
            var flag = false
            return this.filter {
                if (it.isBlank()) {
                    return@filter false
                }

                if (it.split("/**")[0].isBlank()) {
                    flag = true
                    return@filter false
                }

                if (it.contains("*/") && it.split("*/").last().isBlank()) {
                    flag = false
                    return@filter false
                }

                if (flag) {
                    return@filter false
                }

                true
            }
        }
    }


}