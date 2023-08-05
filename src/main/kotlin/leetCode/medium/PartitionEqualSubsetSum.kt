package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class PartitionEqualSubsetSum {
    fun canPartition(nums: IntArray): Boolean {
        nums.sort()

        val sum = nums.sum()

        if (sum.rem(2) != 0) return false

        val target = sum / 2

        val dp = BooleanArray(target + 1)
        dp[0] = true

        for (i in 1..nums.size) {
            for (j in target downTo nums[i - 1]) {
                dp[j] = dp[j] || dp[j - nums[i - 1]]
            }
        }

        return dp[target]
    }
}

fun main(args: Array<String>) {
    val solution = PartitionEqualSubsetSum()
    val example1 = solution.canPartition(intArrayOf(1, 5, 11, 5))
    assertEquals(true, example1)

    val example2 = solution.canPartition(intArrayOf(1, 2, 3, 5))
    assertEquals(false, example2)

    val example3 = solution.canPartition(
        intArrayOf(
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            99,
            97
        )
    )
    assertEquals(false, example3)

    val example4 = solution.canPartition(intArrayOf(1, 2, 3, 4, 5, 6, 7))
    assertEquals(true, example4)
}