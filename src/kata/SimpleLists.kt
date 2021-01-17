package com.code_kata.kata

import java.lang.NullPointerException

class SinglyLinkedList {
    class SingleNode(val value: String, var next: SingleNode?) {
        fun value() = this.value
    }
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

    fun values(): List<String>{
        val values = mutableListOf<String>()
        var node: SingleNode = firstNode ?: throw NullPointerException("NULL!!")

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