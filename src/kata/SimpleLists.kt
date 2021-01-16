package com.code_kata.kata

import java.lang.NullPointerException

class SinglyLinkedList {
    data class SingleNode(val data: String, var next: SingleNode?)
    private var firstNode: SingleNode? = null

    fun add(newData: String) {
        if (firstNode == null) {
            firstNode = SingleNode(newData, null)
            return
        }


        assignNewData(newData, firstNode)
    }

    fun assignNewData(newData: String, node: SingleNode?) {
        if (node?.next == null) {
            node?.next = SingleNode(newData, null)
        } else {
            assignNewData(newData, node.next)
        }
    }

    fun values(): MutableList<String>{
        val list = mutableListOf<String>()

        var node: SingleNode = firstNode ?: throw NullPointerException("NULL!!")
        while (true) {
            list.add(node.data)
            if (node.next == null) break
            node = node.next!!
        }

        return list
    }

}