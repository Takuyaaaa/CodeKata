package com.code_kata.karate_chop

class KarateChop {
    companion object {
        // chop a list by iterating numbers
        fun iteratorChop(targetNum: Int, list: List<Int>): Int {
            for ((index, number) in list.withIndex()) {
                if (number == targetNum) {
                    return index
                }
            }

            // when targetNum not found, return -1
            return -1
        }
    }
}