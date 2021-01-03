package com.code_kata.code_kata

class Rack {
    // balls stored at Rack instance by "add" method
    val balls = mutableListOf<Int>()

    /**
     * store ball number at "balls" in the sorted order
     */
    fun add(ball: Int) {
        balls.add(ball)

        // balls.sort() will do, but this time try to implement by scratch
        balls.bubbleSort()
    }

    /**
     * sort list by bubble sort algorithm
     */
    private fun MutableList<Int>.bubbleSort() {
        this.mapIndexed { index, num ->
            // from the bottom, compare a number to next number
            this.slice(index..this.lastIndex)
                    .reversed().forEach { newtNum ->
                        // if number is bigger than next number, swap their positions
                        if (newtNum < num) {
                            this[index] = newtNum
                            this[index+1] = num
                        }
                    }
        }
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