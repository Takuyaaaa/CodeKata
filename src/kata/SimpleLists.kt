package com.code_kata.kata

class SinglyLinkedList {
    // node which has next pointer to next node
    data class SingleNode(val value: String, var next: SingleNode?)
    // node stored as first one at SinglyLinkedList instance
    var firstNode: SingleNode? = null

    /**
     * add element to singly linked list
     */
    fun add(newValue: String) {
        // if first node is not assigned, set "newValue" as first one
        if (firstNode == null)
            firstNode = SingleNode(newValue, null)
        else
            assignNewValue(newValue, firstNode)
    }

    /**
     * assign new value as last element
     */
    private fun assignNewValue(newValue: String, node: SingleNode?) {
        // if "node" is the last element, assign new node as the last one
        if (node?.next == null)
            node?.next = SingleNode(newValue, null)
       else
            // call the method recursively to reach the last element
            assignNewValue(newValue, node.next)
    }

    /**
     * find and return SingleNode if exist
     */
    fun find(value: String): SingleNode? {
        var node: SingleNode? = firstNode

        while (true) {
            if (node?.value == value) return node
            // if target not found, return null
            if (node?.next == null) return null

            node = node.next
        }
    }

    /**
     * delete node from singly linked list
     */
    fun delete(targetNode: SingleNode) {
        var node: SingleNode? = firstNode
        if (targetNode == node) firstNode = node.next

        while (true) {
            if (targetNode == node?.next) deleteNextNode(node)
            // if target not found, return and finish the process
            if (node?.next == null) return

            node = node.next
        }
    }

    /**
     * delete next node by setting next next node as next one
     */
    private fun deleteNextNode(node: SingleNode) {
        val nextNextNode = node.next?.next
        node.next = nextNextNode
    }

    /**
     * return all values stored at singly linked list
     */
    fun values(): List<String>{
        val values = mutableListOf<String>()
        var node: SingleNode? = firstNode

        while (true) {
            node?.value?.let { values.add(it) }
            // if "node" is the last element, break and finish the process
            if (node?.next == null) break

            node = node.next
        }

        return values
    }
}