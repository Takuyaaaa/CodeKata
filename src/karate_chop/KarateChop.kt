package com.code_kata.karate_chop

import kotlin.math.ceil

class KarateChop {
    companion object {
        // int value returned when targetNum is not found
        private const val NOT_FOUND = -1

        /**
         * calculate list`s index located at middle
         */
        private fun List<Int>.calculateMiddleIndex(): Int {
            return ceil(this.lastIndex.toDouble().div(2.0)).toInt()
        }

        /**
         * chop a list by binary search with iterating
         */
        fun iteratorChop(targetNum: Int, originalList: List<Int>): Int {
            // no calculation needed if originalList is empty
            if (originalList.isEmpty()) return NOT_FOUND

            var middleIndex = originalList.calculateMiddleIndex()
            // prepare a list which would be manipulated through the while process below
            var manipulatedList = originalList

            // keep processing until find targetNum or realize no targetNum
            while (true) {
                // number which is located at middle and will be compared to targetNum
                val middleNum = originalList[middleIndex]

                // found!
                if (middleNum == targetNum) return middleIndex


                // when only one number left and that is not matched to targetNum
                if (manipulatedList.size == 1 && middleNum != targetNum) return NOT_FOUND


                // when only two numbers left and neither of them are not matched to targetNum
                if (manipulatedList.size == 2 && !manipulatedList.contains(targetNum)) return NOT_FOUND


                // when middleNum is smaller than targetNum, pick upper half as manipulatedList
                if (middleNum < targetNum) {
                    manipulatedList = manipulatedList.slice(middleIndex..manipulatedList.lastIndex)
                    middleIndex += manipulatedList.calculateMiddleIndex()
                    continue
                }

                // when middleNum is bigger than targetNum, pick lower half as manipulatedList
                if (middleNum > targetNum) {
                    manipulatedList = manipulatedList.slice(0..middleIndex)
                    middleIndex -= manipulatedList.calculateMiddleIndex()
                    continue
                }
            }
        }

        /**
         * chop a list by binary search recursively
         */
        fun recursiveChop(targetNum: Int, list: List<Int>, offsetIndex: Int = 0): Int {
            // no calculation needed if originalList is empty
            if (list.isEmpty()) return NOT_FOUND

            var middleIndex = list.calculateMiddleIndex()
            val middleNum = list[middleIndex]
            // plus offsetIndex to reflect original list`s index position
            middleIndex += offsetIndex

            // found!
            if (middleNum == targetNum) return middleIndex

            // when only two numbers left and neither of them are not matched to targetNum
            if (list.size <= 2 && !list.contains(targetNum)) return NOT_FOUND

            // when middleNum is smaller than targetNum, call recursiveChop on upper part
            if (middleNum < targetNum) {
                val upperPart = list.slice(middleIndex..list.lastIndex)
                // pass offsetIndex param to reflect original list`s index position
                return recursiveChop(targetNum, upperPart, list.size-upperPart.size)
            }

            // when middleNum is bigger than targetNum, call recursiveChop on lower part
            if (middleNum > targetNum) {
                val lowerPart = list.slice(0 until middleIndex)
                return recursiveChop(targetNum, lowerPart)
            }

            // when none of the above conditions met, return NOT_FOUND int value
            return NOT_FOUND
        }
    }
}