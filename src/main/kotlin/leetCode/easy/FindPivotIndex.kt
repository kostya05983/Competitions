package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class FindPivotIndex {
    fun pivotIndex(nums: IntArray): Int {
        val sum = nums.sum()

        var current = 0
        for (i in nums.indices) {
            val num = nums[i]
            if ((sum - num) - current == current) {
                return i
            }
            current += nums[i]
        }
        return -1
    }
}

fun main(args: Array<String>) {
    val solution = FindPivotIndex()
    val example1 = solution.pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6))
    assertEquals(3, example1)

    val example2 = solution.pivotIndex(intArrayOf(1, 2, 3))
    assertEquals(-1, example2)

    val example3 = solution.pivotIndex(intArrayOf(2, 1, -1))
    assertEquals(0, example3)
}