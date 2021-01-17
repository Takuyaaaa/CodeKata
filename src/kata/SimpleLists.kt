package com.code_kata.kata

import java.lang.NullPointerException

class SinglyLinkedList {
    data class SingleNode(val data: String, var next: SingleNode?)
    var firstNode: SingleNode? = null

    fun add(newData: String) {
        if (firstNode == null)
            firstNode = SingleNode(newData, null)
        else
            // put !! calling as smart casting is not working as
            // "firstNode" is var property
            assignNewData(newData, firstNode!!)
    }

    private fun assignNewData(newData: String, node: SingleNode) {
        if (node.next == null)
            node.next = SingleNode(newData, null)
       else
            // put !! calling as smart casting is not working as
            // "firstNode" is var property
            assignNewData(newData, node.next!!)
    }

    fun values(): List<String>{
        val values = mutableListOf<String>()
        var node: SingleNode = firstNode ?: throw NullPointerException("NULL!!")

        while (true) {
            values.add(node.data)
            if (node.next == null) break
            // put !! calling as smart casting is not working as
            // "firstNode" is var property
            node = node.next!!
        }

        return values
    }
}