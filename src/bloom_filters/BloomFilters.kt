package com.code_kata.bloom_filters

import org.apache.commons.codec.digest.DigestUtils
import java.io.File

class BloomFilters(bytes_size: Int, file: File) {
    private val bloomArray = IntArray(bytes_size)

    /**
     * read a file passed when constructing the class
     * and store hash info of words written in the file at bloomArray
     */
    init {
        file.bufferedReader()
            .readLines()
            .forEach{
                val(md5HashNum, sha256HashNum) = generateHashes(it)

                bloomArray[md5HashNum] = 1
                bloomArray[sha256HashNum] = 1
            }
    }

    /**
     * generate hash values in two ways; md5Hex and sha256Hex
     */
    private fun generateHashes(word: String): List<Int> {
        val md5HashNum = DigestUtils.md5Hex(word).firstHexNum()
        val sha256HashNum = DigestUtils.sha256Hex(word).firstHexNum()

        return listOf(md5HashNum, sha256HashNum)
    }

    /**
     * chunk each consecutive hexadecimal numbers and return first one as Int
     */
    private fun String.firstHexNum(): Int {
        return this.chunked(1)[0].toInt(16)
    }

    /**
     * check if a passed word is included to a property file by referring bloomArray
     */
    fun includes(word: String): Boolean {
        val(md5HashNum, sha256HashNum) = generateHashes(word)

        return when {
            bloomArray[md5HashNum] == 1 && bloomArray[sha256HashNum] == 1 -> true
            else -> false
        }
    }
}