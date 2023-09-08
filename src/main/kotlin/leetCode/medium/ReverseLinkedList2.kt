package leetCode.medium

import java.util.*

class ReverseLinkedList2 {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val stack = Stack<ListNode>()

        var i = 1
        var current = head
        var startPoint: ListNode? = null
        var endPoint: ListNode? = null
        while (current != null) {
            if (i + 1 == left) {
                startPoint = current
            }
            if (i == right + 1) {
                endPoint = current
            }
            if (i in left..right) {
                stack.push(current)
            }

            i++
            current = current.next
        }

        current = startPoint
        while (stack.isNotEmpty()) {
            val pop = stack.pop()
            pop.next = null

            if (current == null) {
                startPoint = pop
                current = pop
                continue
            }

            current.next = pop
            current = current.next
        }
        current?.next = endPoint

        return if (left == 1) startPoint else head
    }
}

fun main(args: Array<String>) {
    val solution = ReverseLinkedList2()
    val example1 = solution.reverseBetween(ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }, 2, 4)
    println(example1)

    val example2 = solution.reverseBetween(ListNode(5), 1, 1)
    println(example2)

    val example3 = solution.reverseBetween(ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }, 1, 5)
    println(example3)
}