package com.code_kata.karate_chop

import kotlin.math.ceil

class KarateChop {
    companion object {
        private const val NOT_FOUND = -1
        /**
         * chop a list by binary search with iterating
         */
        fun iteratorChop(targetNum: Int, originalList: List<Int>): Int {
            /**
             * calculate list`s index located at middle
             */
            fun List<Int>.calculateMiddleIndex(): Int {
                return ceil(this.lastIndex.toDouble().div(2.0)).toInt()
            }

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
                if (manipulatedList.size == 2 &&
                    manipulatedList[0] != targetNum &&
                    manipulatedList.last() != targetNum) return NOT_FOUND


                // when targetNum is bigger than middleNum, pick upper half as manipulatedList
                if (middleNum < targetNum) {
                    manipulatedList = manipulatedList.slice(middleIndex..manipulatedList.lastIndex)
                    middleIndex += manipulatedList.calculateMiddleIndex()
                    continue
                }

                // when targetNum is smaller than middleNum, pick lower half as manipulatedList
                if (middleNum > targetNum) {
                    manipulatedList = manipulatedList.slice(0..middleIndex)
                    middleIndex -= manipulatedList.calculateMiddleIndex()
                    continue
                }
            }
        }
    }
}