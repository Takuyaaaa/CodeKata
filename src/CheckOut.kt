package com.code_kata

class CheckOut(private val unit: MutableMap<String, Int>, private val special: List<Triple<String, Int, Int>> = listOf()) {
    private val totalItemMap = mutableMapOf<String, Int>()
    var total = 0

    fun price(items: String): Int {
        val itemMap = recordItemCount(items, mutableMapOf())
        return calculatePrice(itemMap)
    }

    fun scan(items: String) {
        val mapCopy = HashMap(recordItemCount(items, totalItemMap))
        total = calculatePrice(mapCopy)
    }

    private fun recordItemCount(items: String, itemMap: MutableMap<String, Int> = totalItemMap): MutableMap<String, Int> {
        items.chunked(1).forEach {
            try {
                val count = itemMap.getByKey(it)
                itemMap[it] = count.plus(1)
            } catch (e: IllegalArgumentException) {
                itemMap[it] = 1
            }
        }
        return itemMap
    }

    private fun calculatePrice(itemMap: MutableMap<String, Int>): Int {
        var acc = 0
        acc += calculateSpecialPrice(itemMap)
        acc += calculateUnitPrice(itemMap)
        return acc
    }

    private fun calculateSpecialPrice(itemMap: MutableMap<String, Int>): Int {
        var acc = 0
        special.forEach {
            if (itemMap.containsKey(it.first)) {
                while (itemMap.getByKey(it.first) >= it.second) {
                    acc += it.third
                    val count = itemMap.getByKey(it.first)
                    itemMap[it.first] = count.minus(it.second)
                }
            }
        }
        return acc
    }

    private fun calculateUnitPrice(itemMap: MutableMap<String, Int>): Int {
        var acc = 0
        itemMap.forEach {
            val price = unit.getByKey(it.key)
            while (it.value > 0) {
                acc += price
                val count = itemMap.getByKey(it.key)
                itemMap[it.key] = count.minus(1)
            }
        }
        return acc
    }

    private fun MutableMap<String, Int>.getByKey(key: String): Int {
        return this[key] ?: throw IllegalArgumentException("invalid item passed")
    }
}