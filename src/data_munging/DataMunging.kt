package com.code_kata.data_munging

import java.io.File
import kotlin.math.absoluteValue


class DataMunging {
    companion object {
        /**
         * calculate the smallest temperature spread and return that value with date
         */
        fun File.calculateTemperatureSpread(): Map<String, String> {
            return this.bufferedReader()
                    .readLines()
                    .drop(2).dropLast(1)
                    .map {
                        // process string data to cleansed list data
                        val line = it.cleanseDataFormat()

                        val date = line[0]
                        // extract temperature data to calculate spread
                        val maxTemp = line[1].toInt()
                        val minTemp = line[2].toInt()
                        // make a map containing date and spread as keys
                        mapOf("date" to date, "spread" to maxTemp.minus(minTemp).toString())
                    }
                    // have smallest spread date as first element and pick it to print
                    .sortedBy { it["spread"] }[0]
        }

        /**
         * cleans raw string data to neat list data
         */
        fun String.cleanseDataFormat(): List<String> {
            return this.replace("\\s+".toRegex(), " ")
                    .replace("*", "")
                    .split(" ")
                    .drop(1)
        }


        /**
         * calculate the smallest score spread and return that value with team
         */
        fun File.calculateScoreSpread(): Map<String, String> {
            return this.bufferedReader()
                    .readLines()
                    .drop(1)
                    .mapNotNull{
                        // process string data to cleansed list data
                        val line = it.cleanseDataFormat()

                        // there is the row only for separation "------------------...", not team info
                        // instead of processing, just return null for that separation row
                        if (line.size != 1) {
                            val team = line[1]
                            // extract score data to calculate spread
                            val scoreFor = line[6].toInt()
                            val scoreAgainst = line[8].toInt()
                            // make a map containing team and spread as keys
                            mapOf("team" to team, "spread" to scoreFor.minus(scoreAgainst).absoluteValue.toString())
                        } else null
                    }
                    .sortedBy { it["spread"] }[0]
        }
    }
}