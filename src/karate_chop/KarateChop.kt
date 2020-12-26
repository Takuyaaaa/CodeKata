package com.code_kata.karate_chop

class KarateChop {
    companion object {
        // chop a list by iterating numbers
        fun iteratorChop(targetNum: Int, list: List<Int>): Int {
            if (list.isEmpty()) {
                return -1
            }

            var middleIndex = list.lastIndex/2
            var middleNumber = list[middleIndex]
            var modList = list

            while (true) {
                if (middleNumber == targetNum) {
                    return middleIndex
                }

                if (middleIndex == 0 || middleIndex == list.lastIndex && list[middleIndex] != targetNum) {
                    return -1
                }

                if (middleNumber < targetNum) {
                    val upperPart = list.slice(middleIndex..list.lastIndex)
                    middleIndex += (upperPart.size / 2)
                    middleNumber = list[middleIndex]
                    continue
                }

                if (middleNumber > targetNum) {
                    val lowerPart = list.slice(0..middleIndex)
                    middleIndex = lowerPart.lastIndex/2
                    middleNumber = list[middleIndex]
                    continue
                }
            }
        }
    }
}