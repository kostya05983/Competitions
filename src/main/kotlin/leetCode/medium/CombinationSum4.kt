package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.system.measureTimeMillis

class CombinationSum4 {

    fun combinationSum4(nums: IntArray, target: Int): Int {
        val dp = IntArray(target + 1)
        dp[0] = 1
        for (i in 1..target) {
            for (num in nums) {
                if (num <= i) {
                    dp[i] += dp[i - num]
                }
            }
        }

        return dp[target]
    }


    fun combinationSum4Dp(nums: IntArray, target: Int): Int {
        return combination(nums, 0, 0, target, HashMap())
    }

    private fun combination(
        nums: IntArray,
        index: Int,
        current: Int,
        target: Int,
        dp: MutableMap<Pair<Int, Int>, Int>
    ): Int {
        if (current == target) {
            return 1
        }
        if (current > target) {
            return 0
        }
        val memorized = dp[index to current]
        if (memorized != null) return memorized

        var sumCombination = 0
        for (i in nums.indices) {
            val added = current + nums[i]
            sumCombination += combination(nums, i, added, target, dp)
        }
        dp[index to current] = sumCombination

        return sumCombination
    }
}

fun main(args: Array<String>) {
    val solution = CombinationSum4()
    val example1 = solution.combinationSum4(intArrayOf(1, 2, 3), 4)
    assertEquals(7, example1)
//
    val example2 = solution.combinationSum4(intArrayOf(9), 3)
    assertEquals(0, example2)

    val example3 = solution.combinationSum4(intArrayOf(4, 2, 1), 32)
    assertEquals(39882198, example3)

    val example4 = measureTimeMillis {
        solution.combinationSum4(intArrayOf(2, 1, 3), 35)
    }
    println(example4)
}