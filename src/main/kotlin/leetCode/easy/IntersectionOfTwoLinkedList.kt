package leetCode.easy

import leetCode.ListNode

class IntersectionOfTwoLinkedList {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        if (headA == headB) return headA

        val (aSize, tailA) = getSizeAndTail(headA)
        val (bSize, tailB) = getSizeAndTail(headB)
        if (tailA !== tailB) return null

        var currentA = headA
        var currentB = headB

        if (aSize > bSize) {
            var diff = aSize - bSize

            while (diff != 0) {
                currentA = currentA?.next
                diff--
            }
        } else {
            var diff = bSize - aSize

            while (diff != 0) {
                currentB = currentB?.next
                diff--
            }
        }

        while (currentA != null) {
            if (currentA === currentB) return currentA

            currentA = currentA.next
            currentB = currentB?.next
        }

        return null
    }

    private fun getSizeAndTail(headA: ListNode?): Pair<Int, ListNode?> {
        var size = 1
        var current = headA
        while (current?.next != null) {
            size++
            current = current.next
        }

        return Pair(size, current)
    }
}

fun main(args: Array<String>) {
    var t: ListNode = ListNode(3)
    println(IntersectionOfTwoLinkedList().getIntersectionNode(t, ListNode(2).apply {
        next = t
    }))
}