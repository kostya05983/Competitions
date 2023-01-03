package leetCode.easy

import leetCode.ListNode

class ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        var current = head
        var parent: ListNode? = null

        while (current != null) {
            val next = current.next
            if (parent != null) {
                current.next = parent
            } else {
                current.next = null
            }

            parent = current
            current = next
        }

        return parent
    }
}

fun main(args: Array<String>) {
    val result = ReverseLinkedList().reverseList(ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    })
    println(result)
}