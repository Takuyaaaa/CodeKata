package com.code_kata.code_kata

class Rack {
    // balls stored at Rack instance by "add" method
    var balls = mutableListOf<Int>()

    /**
     * store ball number at "balls" in the sorted order
     */
    fun add(ball: Int) {
        balls.add(ball)

        // balls.sort() will do, but this time try to implement by scratch
        balls = balls.bubbleSort()
    }

    /**
     * sort list by bubble sort algorithm
     */
    private fun MutableList<Int>.bubbleSort(): MutableList<Int> {
        val list = this.reversAsMutable()
        list.forEachIndexed { index, num ->
            if (list.lastIndex >= index+1) {
                if (num < list[index+1]) {
                    list[index] = list[index+1]
                    list[index+1] = num
                }
            }
        }


        return  list.reversAsMutable()
    }

    fun MutableList<Int>.reversAsMutable(): MutableList<Int> {
        return this.reversed().toMutableList()
    }
}


class Sentence(private val sentence: String) {
    /**
     * make "sentence" sorted and remove punctuations
     */
    fun extractSortedChars(): String {
        return sentence.replace(" ", "")
                .removePunctuations()
                .map { it.toLowerCase() }
                // sort alphabetically
                .sortedBy { it }
                // make list to String
                .joinToString("")
    }

    /**
     * remove punctuations from String
     */
    private fun String.removePunctuations(): String {
        return this.filter { it != ',' }
                .filter { it != '.' }
    }
}