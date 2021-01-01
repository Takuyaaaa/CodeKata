package com.code_kata

class CheckOut(private val unit: Map<String, Int>, special: List<Triple<String, Int, Int>> = listOf()) {

    fun price(items: String): Int {
        val countMap = mutableMapOf<String, Int>()

        items.chunked(1)
                .forEach {
                    try {
                        val count = countMap.getByKey2(it)
                        countMap[it] = count.plus(1)
                    } catch (e: IllegalArgumentException) {
                        countMap[it] = 1
                    }
                }

        println(countMap)

        var acc = 0

        items.chunked(1).forEach {
            acc += referPrice(it)
        }

        return acc
    }

    private fun referPrice(item: String): Int {
        return when {
            item.isBlank() -> 0
            else ->  unit.getByKey(item)
        }
    }

    fun Map<String, Int>.getByKey(key: String): Int {
        return this[key] ?: throw IllegalArgumentException("invalid item passed")
    }

    fun MutableMap<String, Int>.getByKey2(key: String): Int {
        return this[key] ?: throw IllegalArgumentException("invalid item passed")
    }
}