package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class MonotonicArray {
    fun isMonotonic(nums: IntArray): Boolean {
        var i = 0
        var increasing = true
        var decreasing = true
        while (i < nums.size - 1) {
            increasing = increasing.and(nums[i] <= nums[i + 1])
            decreasing = decreasing.and(nums[i] >= nums[i + 1])
            i++
        }

        return increasing.or(decreasing)
    }
}

fun main(args: Array<String>) {
    val solution = MonotonicArray()
    val example1 = solution.isMonotonic(intArrayOf(1, 2, 2, 3))
    assertEquals(true, example1)
    val example2 = solution.isMonotonic(intArrayOf(6, 5, 4, 4))
    assertEquals(true, example2)
    val example3 = solution.isMonotonic(intArrayOf(1, 3, 2))
    assertEquals(false, example3)

    val example4 = solution.isMonotonic(intArrayOf(1, 1, 0))
    assertEquals(true, example4)
}