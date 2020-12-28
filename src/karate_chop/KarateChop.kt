package com.code_kata.karate_chop

class KarateChop {
    companion object {
        // int value returned when targetNum is not found
        private const val NOT_FOUND = -1

        /**
         * chop a list by binary search with iterating
         */
        fun iteratorChop(targetNum: Int, list: List<Int>): Int {
            var low = 0
            var high = list.lastIndex

            while (low <= high) {
                val mid = (low + high).div(2)
                val midNum = list[mid]
                val result = compareValues(midNum, targetNum)

                when {
                    result < 0 -> low = mid + 1
                    result > 0 -> high = mid - 1
                    else -> return mid
                }
            }
            return NOT_FOUND
        }

        /**
         * chop a list by binary search recursively
         */
        fun recursiveChop(targetNum: Int, list: List<Int>, offsetIndex: Int = 0): Int {
            var low = 0
            var high = list.lastIndex

            if (list.isEmpty()) return NOT_FOUND

            val mid = (low + high).div(2)
            val midNum = list[mid]
            val result = compareValues(midNum, targetNum)

            return when {
                result < 0 -> {
                    low = mid + 1
                    // pass offsetIndex param to adjust original index position
                    recursiveChop(targetNum, list.slice(low..list.lastIndex), offsetIndex.plus(low))
                }
                result > 0 -> {
                    high = mid - 1
                    recursiveChop(targetNum, list.slice(0 .. high))
                }
                else -> mid.plus(offsetIndex)
            }
        }

        /**
         * chop a list by library binary search function
         */
        fun libraryChop(targetNum: Int, list: List<Int>): Int {
            val result =  list.binarySearch(targetNum)
            // when targetNum is not found, need to return NOT_FOUND int value
            if (result < 0) return NOT_FOUND

            return result
        }
    }
}