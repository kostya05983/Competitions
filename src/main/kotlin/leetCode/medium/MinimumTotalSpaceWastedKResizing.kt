package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class MinimumTotalSpaceWastedKResizing {
    fun minSpaceWastedKResizing(nums: IntArray, k: Int): Int {
        return helper(nums, k, 0, 0, 0, 0, mutableMapOf())
    }

    //(max-sum/amount)*amount=max*amount-sum
    private fun helper(
        nums: IntArray,
        k: Int,
        index: Int,
        localMax: Int,
        amount: Int,
        sum: Int,
        memory: MutableMap<Pair<Int, Int>, Int>
    ): Int {
        val key = Pair(index, k)

        val memorized = memory[key]
        if (memorized != null) {
            return memorized
        }

        val newMax = maxOf(localMax, nums[index])
        val newSum = sum + nums[index]

        if (index == nums.lastIndex) return newMax * (amount + 1) - newSum

        if (k == 0) {
            return helper(nums, k, index + 1, newMax, amount + 1, newSum, memory)
        }

        val diff = newMax * (amount + 1) - newSum

        val usedK = helper(nums, k - 1, index + 1, nums[index + 1], 0, 0, memory)
        memory[Pair(index + 1, k - 1)] = usedK

        val one = diff + usedK
        val two = helper(nums, k, index + 1, newMax, amount + 1, newSum, memory)

        return minOf(one, two)
    }
}

fun main(args: Array<String>) {
    val solution = MinimumTotalSpaceWastedKResizing()
    val example1 = solution.minSpaceWastedKResizing(intArrayOf(10, 20), 0)
    assertEquals(10, example1)

    val example2 = solution.minSpaceWastedKResizing(intArrayOf(10, 20, 30), 1)
    assertEquals(10, example2)

    val example3 = solution.minSpaceWastedKResizing(intArrayOf(10, 20, 15, 30, 20), 2)
    assertEquals(15, example3)

    val example4 = solution.minSpaceWastedKResizing(
        intArrayOf(
            438,
            575,
            10,
            115,
            78,
            968,
            905,
            708,
            926,
            153,
            559,
            37,
            855,
            379,
            597,
            566,
            152,
            441,
            131,
            43,
            316,
            374,
            921,
            956,
            816,
            996,
            882,
            41,
            921,
            367,
            216,
            699,
            256,
            683,
            106,
            363,
            799,
            574,
            906,
            896,
            417,
            998,
            636,
            768,
            159,
            948
        ), 45
    )
    assertEquals(0, example4)

    val example5 = solution.minSpaceWastedKResizing(
        intArrayOf(
            29, 38, 18, 1, 49, 11, 45, 28
        ),
        3
    )
    assertEquals(68, example5)
}