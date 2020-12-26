package com.code_kata.karate_chop

import kotlin.math.ceil

class KarateChop {
    companion object {
        // chop a list by iterating numbers
        fun iteratorChop(targetNum: Int, list: List<Int>): Int {
            if (list.isEmpty()) {
                return -1
            }

            var middleIndex = ceil(list.lastIndex.toDouble().div(2.0)).toInt()
            var middleNumber = list[middleIndex]
            var modList = list

            while (true) {
                if (middleNumber == targetNum) {
                    return middleIndex
                }

                if (modList.size == 1 && middleNumber != targetNum) {
                    return -1
                }

                if (modList.size == 2 && modList[0] != targetNum && modList.last() != targetNum) {
                    return -1
                }

                if (middleNumber < targetNum) {
                    modList = modList.slice(middleIndex..modList.lastIndex)
                    middleIndex += ceil(modList.lastIndex.toDouble().div(2.0)).toInt()
                    middleNumber = list[middleIndex]
                    continue
                }

                if (middleNumber > targetNum) {
                    modList = modList.slice(0..middleIndex)
                    middleIndex -= ceil(modList.lastIndex.toDouble().div(2.0)).toInt()
                    middleNumber = list[middleIndex]
                    continue
                }
            }
        }
    }
}