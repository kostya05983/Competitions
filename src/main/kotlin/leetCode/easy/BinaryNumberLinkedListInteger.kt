package leetCode.easy

import leetCode.medium.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.math.pow

class BinaryNumberLinkedListInteger {
    fun getDecimalValue(head: ListNode?): Int {
        var current = head
        var size = 0
        while (current != null) {
            current = current.next
            size++
        }

        current = head
        var number = 0
        var degree = size - 1
        while (current != null) {
            if (current.`val` == 1) {
                number += 2.0.pow(degree.toDouble()).toInt()
            }
            current = current.next
            degree--
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