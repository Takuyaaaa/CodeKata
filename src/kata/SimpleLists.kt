package com.code_kata.kata

import java.lang.NullPointerException

class SinglyLinkedList {
    data class SingleNode(val value: String, var next: SingleNode?)
    var firstNode: SingleNode? = null

    fun add(newValue: String) {
        if (firstNode == null)
            firstNode = SingleNode(newValue, null)
        else
            // put !! calling as smart casting is not working as
            // "firstNode" is var property
            assignNewData(newValue, firstNode!!)
    }

    private fun assignNewData(newData: String, node: SingleNode) {
        if (node.next == null)
            node.next = SingleNode(newData, null)
       else
            // put !! calling as smart casting is not working as
            // "firstNode" is var property
            assignNewData(newData, node.next!!)
    }

    fun find(value: String): SingleNode? {
        var node: SingleNode = firstNode ?: return null

        while (true) {
            if (node.value == value) return node
            if (node.next == null) return null
            // put !! calling as smart casting is not working as
            // "firstNode" is var property
            node = node.next!!
        }
    }

    fun delete(targetNode: SingleNode) {
        var node: SingleNode = firstNode ?: return
        if (targetNode == node) {
            firstNode = node.next
        }
        while (true) {

            if (targetNode == node.next) {
                // 削除処理
                val nextNextNode = node.next?.next
                node.next = nextNextNode
            }
            if (node.next == null) return
            // put !! calling as smart casting is not working as
            // "firstNode" is var property
            node = node.next!!
        }
    }

    fun values(): List<String>{
        val values = mutableListOf<String>()
        var node: SingleNode = firstNode ?: return values

        while (true) {
            values.add(node.value)
            if (node.next == null) break
            // put !! calling as smart casting is not working as
            // "firstNode" is var property
            node = node.next!!
        }

        return values
    }
}