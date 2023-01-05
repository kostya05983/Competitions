package leetCode.easy

import leetCode.ListNode

class RemoveLinkedListElements {

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var newHead = head
        var current = head
        var parent: ListNode? = null

        while (current != null) {
            if (current.`val` == `val`) {
                if (newHead == current) {
                    newHead = current.next
                } else {
                    parent?.next = current.next
                    current = current.next
                    continue
                }

            }

            parent = current
            current = current.next
        }

        return newHead
    }
}

fun main(args: Array<String>) {
    println(RemoveLinkedListElements().removeElements(ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }, 1))

    println(RemoveLinkedListElements().removeElements(ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }, 3))

    println(RemoveLinkedListElements().removeElements(ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(2).apply {
                next = ListNode(1)
            }
        }
    }, 2))

}