package com.code_kata.kata

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
                    it.multipleLinesCommentStarts(inMultipleLinesComments) -> {
                        inMultipleLinesComments = true
                        return@filter it.beforeCodeExists()
                    }

                    // when it ends, flag turns into false and the line would be excluded
                    // if there is no actual code after ending of multiple lines comment
                    it.multipleLinesCommentEnds(inMultipleLinesComments) -> {
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
        private fun String.multipleLinesCommentStarts(inMultipleLinesComments: Boolean): Boolean =
                this.contains("/**") && !inMultipleLinesComments

        /**
         * if multiple lines comment ends
         */
        private fun String.multipleLinesCommentEnds(inMultipleLinesComments: Boolean): Boolean =
                this.contains("*/") && inMultipleLinesComments

        /**
         * if there is no actual code before starting of multiple lines comment
         */
        private fun String.beforeCodeExists(): Boolean  {
            val beforeCode = this.split("/**")[0]
            return beforeCode.isNotBlank() && beforeCode.isNotOneLineComment()
        }

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
        private fun String.isNotOneLineComment(): Boolean  {
            return  this.split("//")[0].isNotBlank()
                    && this.split("/*")[0].isNotBlank()
                    && this.split("*/").last().isNotBlank()
        }
    }
}