package com.code_kata.data_munging

import java.io.File


class DataMunging {
    companion object {
        fun readFileAndPrintSmallestSpread() {
            /**
             * process string data to cleansed list data
             */
            fun String.cleanseDataFormat(): List<String> {
                return this.replace("\\s+".toRegex(), " ")
                        .replace("*", "")
                        .split(" ")
                        .drop(1)
            }

            /**
             * calculate smallest spread and return that date with spread value
             */
            fun File.calculateSmallestSpread(): Map<String, Int> {
                return this.bufferedReader()
                        .readLines()
                        .takeLast(31).dropLast(1)
                        .map {
                            // process string data to cleansed list data
                            val line = it.cleanseDataFormat()

                            val date = line[0].toInt()
                            // extract temperature data to calculate spread
                            val maxTemp = line[1].toInt()
                            val minTemp = line[2].toInt()
                            // make a map containing date and spread as keys
                            mapOf("date" to date, "spread" to maxTemp.minus(minTemp))
                        }
                        // have smallest spread date as first element and pick it to print
                        .sortedBy { it["spread"] }[0]
            }

            val smallestSpread = File("resources/weather.dat")
                    .calculateSmallestSpread()

            println(smallestSpread)
        }
    }
}