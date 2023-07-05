package leetCode.easy

import leetCode.medium.ListNode
import org.junit.jupiter.api.Assertions.assertEquals

class BinaryNumberLinkedListInteger {
    fun getDecimalValue(head: ListNode?): Int {
        var current = head
        var number = 0

        while (current != null) {
            number = number * 2 + current.`val`
            current = current.next
        }

        return number
    }
}


fun main(args: Array<String>) {
    val solution = BinaryNumberLinkedListInteger()
    val example1 = solution.getDecimalValue(ListNode(1).apply {
        next = ListNode(0).apply {
            next = ListNode(1)
        }
    })
    assertEquals(5, example1)

    val example2 = solution.getDecimalValue(ListNode(0))
    assertEquals(0, example2)
}