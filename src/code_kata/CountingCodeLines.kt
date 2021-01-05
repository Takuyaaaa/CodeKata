package com.code_kata.code_kata

import java.io.File

class CountingCodeLines {
    companion object {
        fun File.countCodeLines(): Int {
            return readLines()
                    .excludeBlankLine()
                    .excludeMultipleLinesComment()
                    .excludeOneLineComment()
                    .count()
        }

        private fun List<String>.excludeBlankLine(): List<String> =
                this.filter { it.isNotBlank() }

        private fun List<String>.excludeOneLineComment(): List<String> =
            this.filter { it.split("//")[0].isNotBlank() }



        private fun List<String>.excludeMultipleLinesComment(): List<String> {
            var inMultipleLinesComments = false
            return this.filter {
                when {
                    it.multipleLinesCommentStarts() -> {
                        inMultipleLinesComments = true
                        return@filter false
                    }

                    it.multipleLinesCommentEnds() -> {
                        inMultipleLinesComments = false
                        return@filter it.afterCodeExists()
                    }

                    else -> return@filter !inMultipleLinesComments
                }
            }
        }

        private fun String.multipleLinesCommentStarts(): Boolean =
                this.split("/**")[0].isBlank()

        private fun String.multipleLinesCommentEnds(): Boolean =
                this.contains("*/")

        private fun String.afterCodeExists(): Boolean  {
            val afterCode = this.split("*/").last()
            return afterCode.isNotBlank() && afterCode.isNotSingleLineComment()
        }

        private fun String.isNotSingleLineComment(): Boolean =
                this.split("//")[0].isNotBlank()
    }
}