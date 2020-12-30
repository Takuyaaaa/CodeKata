package com.code_kata.data_munging

import java.io.File
import kotlin.math.absoluteValue
import kotlin.reflect.KFunction1

class DataMunging {
    companion object {
        /**
         * cleans raw string data to neat list data
         */
        private fun String.cleanseDataFormat(): List<String> {
            return this.replace("\\s+".toRegex(), " ")
                    .replace("*", "")
                    .split(" ")
                    .drop(1)
        }

        /**
         * read file and process its data in mapNotNull part with a method passed as argument
         */
        fun File.readFileAndProcessDataWith(operation: KFunction1<String, Map<String, String>?>): Map<String, String> {
            return this.bufferedReader()
                    .readLines()
                    .drop(1).dropLast(1)
                    .mapNotNull {
                        operation(it)
                    }
                    // have smallest spread date as first element and pick it to return
                    .sortedBy { it["spread"]?.toInt() }[0]
        }

        /**
         * calculate the smallest temperature spread and return that value with date
         */
        fun calculateTemperatureSpread(row: String): Map<String, String>? {
            // process string data to cleansed list data
            val line = row.cleanseDataFormat()

            // there is the row that is empty, not weather info
            // instead of processing, just return null for that empty row
            return if (line.isNotEmpty()) {
                val date = line[0]
                // extract temperature data to calculate spread
                val maxTemp = line[1].toInt()
                val minTemp = line[2].toInt()

                mapOf("date" to date, "spread" to maxTemp.minus(minTemp).toString())
            } else null
        }

        /**
         * calculate the smallest score spread and return that value with team
         */
        fun calculateScoreSpread(row: String): Map<String, String>? {
            // process string data to cleansed list data
            val line = row.cleanseDataFormat()

            // there is the row only for separation "------------------...", not team info
            // instead of processing, just return null for that separation row
            return if (line.size != 1) {
                val team = line[1]
                // extract score data to calculate spread
                val scoreFor = line[6].toInt()
                val scoreAgainst = line[8].toInt()

                mapOf("team" to team, "spread" to scoreFor.minus(scoreAgainst).absoluteValue.toString())
            } else null
        }
    }
}