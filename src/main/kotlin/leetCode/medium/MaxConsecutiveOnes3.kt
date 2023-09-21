package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class MaxConsecutiveOnes3 {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var left = 0
        var right = 0

        var zeroCount = 0

        while (right < nums.size) {
            if (nums[right] == 0) {
                zeroCount++
            }

            if (zeroCount > k && nums[left++] == 0) {
                zeroCount--
            }

            right++
        }

        return right - left
    }
}

fun main(args: Array<String>) {
    val solution = MaxConsecutiveOnes3()
    val example1 = solution.longestOnes(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2)

    assertEquals(6, example1)

    val example2 = solution.longestOnes(intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1), 3)
    assertEquals(10, example2)

    val example3 = solution.longestOnes(intArrayOf(0, 0, 0, 0, 0, 0, 1, 1, 1, 1), 0)
    assertEquals(4, example3)
}