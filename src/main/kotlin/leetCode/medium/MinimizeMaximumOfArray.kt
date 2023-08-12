package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class MinimizeMaximumOfArray {
    fun minimizeArrayValue(nums: IntArray): Int {
        var i = 1
        var max = -1L
        var prefixSum = nums[0].toLong()

        val globalMaximum = nums[0]

        while (i < nums.size) {
            prefixSum += nums[i]
            max = maxOf(max, (prefixSum + i) / (i + 1))
            i++
        }

        return if (max > globalMaximum) return max.toInt() else globalMaximum
    }
}

fun main(args: Array<String>) {
    val solution = MinimizeMaximumOfArray()
    val example1 = solution.minimizeArrayValue(intArrayOf(3, 7, 1, 6))
    assertEquals(5, example1)

    val example2 = solution.minimizeArrayValue(intArrayOf(10, 1))
    assertEquals(10, example2)

    val example3 = solution.minimizeArrayValue(intArrayOf(13, 13, 20, 0, 8, 9, 9))
    assertEquals(16, example3)

    val example4 = solution.minimizeArrayValue(intArrayOf(4, 7, 2, 2, 9, 19, 16, 0, 3, 15))
    assertEquals(9, example4)

    val example5 = solution.minimizeArrayValue(intArrayOf(19, 15, 10, 6, 15, 15, 13, 12))
    assertEquals(19, example5)
}