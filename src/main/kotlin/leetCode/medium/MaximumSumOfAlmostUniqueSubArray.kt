package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class MaximumSumOfAlmostUniqueSubArray {
    fun maxSum(nums: List<Int>, m: Int, k: Int): Long {
        var left = 0

        var result = 0L
        var current = 0L
        val frequencies = mutableMapOf<Int, Int>()

        for (right in nums.indices) {
            val rightNum = nums[right]
            current += rightNum

            frequencies[rightNum] = frequencies.getOrDefault(rightNum, 0) + 1

            if (right - left == (k - 1)) {
                val leftNum = nums[left]
                if (frequencies.size >= m) {
                    result = maxOf(current, result)
                }

                val newValue = frequencies[leftNum]!! - 1
                frequencies[leftNum] = newValue
                if (newValue == 0) frequencies.remove(leftNum)
                current -= leftNum
                left += 1
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = MaximumSumOfAlmostUniqueSubArray()
    val example1 = solution.maxSum(listOf(2, 6, 7, 3, 1, 7), 3, 4)
    assertEquals(18, example1)

    val example2 = solution.maxSum(listOf(5, 9, 9, 2, 4, 5, 4), 1, 3)
    assertEquals(23, example2)

    val example3 = solution.maxSum(listOf(1, 2, 1, 2, 1, 2, 1), 3, 3)
    assertEquals(0, example3)

    val example4 = solution.maxSum(listOf(1, 1, 1, 3), 2, 2)
    assertEquals(4, example4)
}