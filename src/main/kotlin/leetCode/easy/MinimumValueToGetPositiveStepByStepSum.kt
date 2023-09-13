package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.math.abs

class MinimumValueToGetPositiveStepByStepSum {
    fun minStartValue(nums: IntArray): Int {
        var min = 0
        var current = 0

        for(num in nums) {
            current += num
            min = minOf(min, current)
        }

        return abs(min) + 1
    }
}

fun main(args: Array<String>) {
    val solution = MinimumValueToGetPositiveStepByStepSum()
    val example1 = solution.minStartValue(intArrayOf(-3, 2, -3, 4, 2))
    assertEquals(5, example1)

    val example2 = solution.minStartValue(intArrayOf(1, 2))
    assertEquals(1, example2)

    val example3 = solution.minStartValue(intArrayOf(1, -2, -3))
    assertEquals(5, example3)
}