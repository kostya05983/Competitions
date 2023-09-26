package leetCode.easy

import leetCode.medium.ListNode

class MiddleOfLinkedList {
    fun middleNode(head: ListNode?): ListNode? {
        var size = 0
        var current = head

        val map = mutableMapOf<Int, ListNode>()
        while (current != null) {
            map[size] = current
            size++
            current = current.next
        }

        val middleIndex = size / 2

        return map[middleIndex]
    }
}

fun main(args: Array<String>) {
    val solution = MiddleOfLinkedList()
}