package com.code_kata.code_kata

class Rack {
    val balls = mutableListOf<Int>()

    fun add(ball: Int) {
        balls.add(ball)

        // balls.sort() will solve the problem, but...
        balls.bubbleSort()
    }

    private fun MutableList<Int>.bubbleSort() {
        this.mapIndexed { index, num ->
            this.slice(index..this.lastIndex)
                    .reversed().forEach { newtNum ->
                        if (newtNum < num) {
                            this[index] = newtNum
                            this[index+1] = num
                        }
                    }
        }
    }
}