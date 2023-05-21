package leetCode.easy

import leetCode.medium.ListNode

class LinkedListCycle {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) return false

        val set = mutableSetOf<ListNode>()

        var current = head
        set.add(head)
        current = current.next
        while (current != null) {
            if (set.contains(current)) return true
            set.add(current)
            current = current.next
        }

        return false
    }
}

fun main(args: Array<String>) {
    println(LinkedListCycle().hasCycle(ListNode(3).apply {
        val t = this
        next = ListNode(2).apply {
            next = ListNode(0).apply {
                next = ListNode(-4).apply {
                    next = ListNode(5).apply {
                        next = t
                    }
                }
            }
        }
    }))

    println(LinkedListCycle().hasCycle(ListNode(3).apply {
        next = ListNode(2).apply {
            val t = this
            next = ListNode(0).apply {
                next = ListNode(-4).apply {
//                    next = t
                }
            }
        }
    }))

    println(LinkedListCycle().hasCycle(ListNode(3).apply {
        next = ListNode(2)
    }))
    println(LinkedListCycle().hasCycle(ListNode(3)))
}