package com.code_kata

class CheckOut(private val unit: Map<String, Int>, private val special: List<Triple<String, Int, Int>> = listOf()) {
    fun price(items: String): Int {
        val itemsMap = mutableMapOf<String, Int>()
        val itemsList = items.chunked(1)

        itemsList.forEach {
                    try {
                        val count = itemsMap.getByKey2(it)
                        itemsMap[it] = count.plus(1)
                    } catch (e: IllegalArgumentException) {
                        itemsMap[it] = 1
                    }
                }

        var acc = 0

        special.forEach {
            if (itemsMap.containsKey(it.first)) {
                while (itemsMap.getByKey2(it.first) >= it.second) {
                    acc += it.third
                    val count = itemsMap.getByKey2(it.first)
                    itemsMap[it.first] = count.minus(it.second)
                }
            }
        }

        itemsMap.forEach {
            val price = unit.getByKey(it.key)
            while (it.value > 0) {
                acc += price
                val count = itemsMap.getByKey2(it.key)
                itemsMap[it.key] = count.minus(1)
            }

        }

        return acc
    }

    fun Map<String, Int>.getByKey(key: String): Int {
        return this[key] ?: throw IllegalArgumentException("invalid item passed")
    }

    fun MutableMap<String, Int>.getByKey2(key: String): Int {
        return this[key] ?: throw IllegalArgumentException("invalid item passed")
    }
}