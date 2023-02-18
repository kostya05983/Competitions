package leetCode.medium

import leetCode.ListNode

class SwapNodesInPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        val newHead = head.next

        var previous: ListNode? = null
        var first = head
        var second = first.next
        while (first != null && second != null) {
            val third = second.next
            first.next = third
            second.next = first

            if (previous != null) {
                previous.next = second
            }

            previous = first
            first = third
            second = third?.next
        }

        return newHead
    }
}

fun main(args: Array<String>) {
    val solution = SwapNodesInPairs()
    val result = solution.swapPairs(ListNode(1, ListNode(2, ListNode(3, ListNode(4)))))
    require(result?.`val` == 2)
    require(result?.next?.`val` == 1)
    require(result?.next?.next?.`val` == 4)
    require(result?.next?.next?.next?.`val` == 3)
}