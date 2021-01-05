package com.code_kata.code_kata

import java.io.File

class CountingCodeLines {
    companion object {
        /**
         * count the number of lines of actual code; i.e. not counting comment lines
         */
        fun File.countCodeLines(): Int {
            return readLines()
                    .filter { it.isNotBlank() }
                    // need to deal with multiple lines comment first as
                    // "//" might be used as first character of multiple lines comment
                    .excludeMultipleLinesComment()
                    .filter { it.isNotOneLineComment() }
                    .count()
        }

        /**
         * exclude multiple lines comment not to count
         */
        private fun List<String>.excludeMultipleLinesComment(): List<String> {
            var inMultipleLinesComments = false
            return this.filter {
                when {
                    // when it starts, flag turns into true and the line would be excluded
                    it.multipleLinesCommentStarts() -> {
                        inMultipleLinesComments = true
                        return@filter false
                    }

                    // when it ends, flag turns into false and the line would be excluded
                    // if there is no actual code after ending of multiple lines comment
                    it.multipleLinesCommentEnds() -> {
                        inMultipleLinesComments = false
                        return@filter it.afterCodeExists()
                    }

                    // when the line is not in multiple lines comment, the line would be passed to count
                    else -> return@filter !inMultipleLinesComments
                }
            }
        }

        /**
         * if multiple lines comment starts
         */
        private fun String.multipleLinesCommentStarts(): Boolean =
                this.split("/**")[0].isBlank()

        /**
         * if multiple lines comment ends
         */
        private fun String.multipleLinesCommentEnds(): Boolean =
                this.contains("*/")

        /**
         * if there is no actual code after ending of multiple lines comment
         */
        private fun String.afterCodeExists(): Boolean  {
            val afterCode = this.split("*/").last()
            return afterCode.isNotBlank() && afterCode.isNotOneLineComment()
        }

        /**
         * if the line is one line comment
         */
        private fun String.isNotOneLineComment(): Boolean =
                this.split("//")[0].isNotBlank()
    }
}