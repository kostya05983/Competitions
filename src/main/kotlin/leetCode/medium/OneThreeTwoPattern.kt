package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.LinkedList

class OneThreeTwoPattern {
    fun find132pattern(nums: IntArray): Boolean {
        if (nums.size < 3) return false

        val monotonicStack = LinkedList<Int>()

        var middle = Int.MIN_VALUE

        for (i in nums.size - 1 downTo 0) {
            val num = nums[i]
            if (num < middle) return true

            while (monotonicStack.isNotEmpty() && monotonicStack.peek() < num) {
                middle = monotonicStack.pop()
            }
            monotonicStack.push(num)
        }

        return false
    }
}

fun main(args: Array<String>) {
    val solution = OneThreeTwoPattern()
    val example1 = solution.find132pattern(intArrayOf(1, 2, 3, 4))
    assertEquals(false, example1)

    val example2 = solution.find132pattern(intArrayOf(3, 1, 4, 2))
    assertEquals(true, example2)

    val example3 = solution.find132pattern(intArrayOf(-1, 3, 2, 0))
    assertEquals(true, example3)

    val example4 = solution.find132pattern(intArrayOf(1, 0, 1, -4, -3))
    assertEquals(false, example4)

    val example5 = solution.find132pattern(intArrayOf(1, 4, 0, -1, -2, -3, -1, -2))
    assertEquals(true, example5)

    val example6 = solution.find132pattern(intArrayOf(3, 5, 0, 3, 4))
    assertEquals(true, example6)
}