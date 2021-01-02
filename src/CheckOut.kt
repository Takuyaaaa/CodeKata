package com.code_kata

class CheckOut(private val unit: Map<String, Int>, private val special: List<Triple<String, Int, Int>> = listOf()) {
    private val totalItemMap = mutableMapOf<String, Int>()
    var total = total()

    fun price(items: String): Int {
        val itemMap = pre(items, mutableMapOf())

        return calculatePrice(itemMap)
    }

    fun total(): Int {
        val mapCopy = HashMap(totalItemMap)

        return calculatePrice(mapCopy)
    }

    fun pre(items: String, itemMap: MutableMap<String, Int> = totalItemMap): MutableMap<String, Int> {
        val itemsList = items.chunked(1)

        itemsList.forEach {
            try {
                val count = itemMap.getByKey2(it)
                itemMap[it] = count.plus(1)
            } catch (e: IllegalArgumentException) {
                itemMap[it] = 1
            }
        }

        return itemMap
    }

    fun scan(items: String, itemMap: MutableMap<String, Int> = totalItemMap) {
        val mapCopy = HashMap(pre(items, itemMap))
        total = calculatePrice(mapCopy)
    }

    fun calculatePrice(itemMap: MutableMap<String, Int>): Int {
        var acc = 0

        acc += calculateSpecialPrice(itemMap)

        acc += calculateUnitPrice(itemMap)

        return acc
    }

    fun calculateSpecialPrice(itemMap: MutableMap<String, Int>): Int {
        var acc = 0
        special.forEach {
            if (itemMap.containsKey(it.first)) {
                while (itemMap.getByKey2(it.first) >= it.second) {
                    acc += it.third
                    val count = itemMap.getByKey2(it.first)
                    itemMap[it.first] = count.minus(it.second)
                }
            }
        }

        return acc
    }

    fun calculateUnitPrice(itemMap: MutableMap<String, Int>): Int {
        var acc = 0

        itemMap.forEach {
            val price = unit.getByKey(it.key)
            while (it.value > 0) {
                acc += price
                val count = itemMap.getByKey2(it.key)
                itemMap[it.key] = count.minus(1)
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