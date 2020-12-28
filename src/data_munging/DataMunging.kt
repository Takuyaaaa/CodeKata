package com.code_kata.data_munging

import java.io.File


class DataMunging {
    companion object {
        fun readFileAndReturnSmallestSpread() {
            val dateWithSpread = File("resources/weather.dat")
                    .bufferedReader()
                    .readLines()
                    .takeLast(31).dropLast(1)
                    .map {
                        // process string data to cleansed list data
                        val line = it.replace("\\s+".toRegex(), " ")
                                .replace("*", "")
                                .split(" ")
                                .drop(1)

                        // extract temperature data to calculate difference
                        val date = line[0].toInt()
                        val maxTemp = line[1].toInt()
                        val minTemp = line[2].toInt()
                        // map list with date and difference of maxTemp and MinTemp
                        listOf(date, maxTemp.minus(minTemp))
                    }
                    // have smallest spread date as first element and pick it to print
                    .sortedBy { it[1] }[0]

            println(dateWithSpread)
        }
    }
}