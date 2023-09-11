package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class LongestIncreasingSubsequence {
    fun lengthOfLIS(nums: IntArray): Int {
        val lis = IntArray(nums.size) { 1 }

        for (i in nums.size - 1 downTo 0) {
            for (j in i + 1 until nums.size) {
                if (nums[i] < nums[j]) {
                    lis[i] = maxOf(lis[i], 1 + lis[j])
                }
            }
        }

        return lis.max()!!
    }
}

fun main(args: Array<String>) {
    val solution = LongestIncreasingSubsequence()

    val example1 = solution.lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18))
    assertEquals(4, example1)

    val example2 = solution.lengthOfLIS(intArrayOf(0, 1, 0, 3, 2, 3))
    assertEquals(4, example2)

    val example3 = solution.lengthOfLIS(intArrayOf(7, 7, 7, 7, 7, 7, 7))
    assertEquals(1, example3)
}