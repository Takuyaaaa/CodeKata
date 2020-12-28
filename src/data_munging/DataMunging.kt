package com.code_kata.data_munging

import java.io.File
import kotlin.math.min


class DataMunging {
    companion object {
        fun process() {
            var f = File("resources/weather.dat").bufferedReader()
                    .readLines()
                    .takeLast(31).dropLast(1)
                    .map {
                        val line = it
                                .replace("\\s+".toRegex(), " ")
                                .replace("*", "")
                                .split(" ")
                        val max_temp = line[2].toInt()
                        val min_temp = line[3].toInt()
                        val diff = max_temp.minus(min_temp)
    //
                        listOf(line[1].toInt(), diff)
                    }
                    .sortedBy { it[1] }
                    .get(0)

            println(f)
        }
    }
}