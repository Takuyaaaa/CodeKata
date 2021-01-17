package com.code_kata.kata

class SinglyLinkedList {
    data class SingleNode(val value: String, var next: SingleNode?)
    var firstNode: SingleNode? = null

    fun add(newValue: String) {
        if (firstNode == null)
            firstNode = SingleNode(newValue, null)
        else
            assignNewData(newValue, firstNode)
    }

    private fun assignNewData(newData: String, node: SingleNode?) {
        if (node?.next == null)
            node?.next = SingleNode(newData, null)
       else
            assignNewData(newData, node.next)
    }

    fun find(value: String): SingleNode? {
        var node: SingleNode? = firstNode

        while (true) {
            if (node?.value == value) return node
            if (node?.next == null) return null

            node = node.next
        }
    }

    fun delete(targetNode: SingleNode) {
        var node: SingleNode? = firstNode
        if (targetNode == node) firstNode = node.next

        while (true) {
            if (targetNode == node?.next) deleteNextNode(node)
            if (node?.next == null) return

            node = node.next
        }
    }

    private fun deleteNextNode(node: SingleNode) {
        val nextNextNode = node.next?.next
        node.next = nextNextNode
    }

    fun values(): List<String>{
        val values = mutableListOf<String>()
        var node: SingleNode? = firstNode

        while (true) {
            node?.value?.let { values.add(it) }
            if (node?.next == null) break

            node = node.next
        }

        return values
    }
}