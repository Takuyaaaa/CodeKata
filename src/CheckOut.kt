package com.code_kata

class CheckOut(private val unitRule: MutableMap<String, Int>, private val specialRule: List<Triple<String, Int, Int>> = listOf()) {
    // map which stores items scanned with "scan" method
    private val totalItemMap = mutableMapOf<String, Int>()
    // total price calculated by items stored at "totalItemMap"
    var total = 0

    /**
     * return price according to items passed
     */
    fun price(items: String): Int {
        val itemMap = recordItemCount(items, mutableMapOf())
        return calculatePrice(itemMap)
    }

    /**
     * scan items and store its data to "totalItemMap" and price to "total"
     */
    fun scan(items: String) {
        // make copy not to affect totalItemMap by process in "calculatePrice"
        val totalItemMapCopy = HashMap(recordItemCount(items, totalItemMap))
        // assign calculated total price to "total"
        total = calculatePrice(totalItemMapCopy)
    }

    /**
     * count items and store its counting data to passed "itemMap"
     */
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

    /**
     * calculate price by referring "unitRule" and "specialRule"
     */
    private fun calculatePrice(itemMap: MutableMap<String, Int>): Int {
        var acc = 0
        // calculate special price first to reflect special price appropriately
        acc += calculateSpecialPrice(itemMap)
        acc += calculateUnitPrice(itemMap)
        return acc
    }

    /**
     * calculate special prices by referring "specialRule"
     */
    private fun calculateSpecialPrice(itemMap: MutableMap<String, Int>): Int {
        var acc = 0
        specialRule.forEach {
            val item = it.first
            val unit = it.second
            val price = it.third

            if (itemMap.containsKey(item)) {
                // while item count is greater than special price unit...
                while (itemMap.getByKey(item) >= unit) {
                    acc += price
                    val count = itemMap.getByKey(item)
                    // minus count of item which are referred to calculate special price
                    itemMap[item] = count.minus(unit)
                }
            }
        }
        return acc
    }

    /**
     * calculate special prices by referring "unitPrice"
     */
    private fun calculateUnitPrice(itemMap: MutableMap<String, Int>): Int {
        var acc = 0
        itemMap.forEach {
            val price = unitRule.getByKey(it.key)
            // while item count is greater than 0...
            while (it.value > 0) {
                acc += price
                val count = itemMap.getByKey(it.key)
                itemMap[it.key] = count.minus(1)
            }
        }
        return acc
    }

    /**
     * get value by key assuring return type is "Int", not "Int?"
     */
    private fun MutableMap<String, Int>.getByKey(key: String): Int {
        return this[key] ?: throw IllegalArgumentException("invalid item passed")
    }
}