package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class CoinChange2 {
    fun change(amount: Int, coins: IntArray): Int {
        val dp = IntArray(amount + 1)
        dp[0] = 1

        for (coin in coins) {
            for (i in coin until amount + 1) {
                dp[i] += dp[i - coin]
            }
        }

        return dp[amount]
    }

    fun change2(amount: Int, coins: IntArray): Int {
        coins.sort()
        return change(amount, coins.lastIndex, coins)
    }

    private val memorization = mutableMapOf<Pair<Int, Int>, Int>()

    private fun change(amount: Int, index: Int, coins: IntArray): Int {
        if (amount < 0 || index == -1) return 0
        if (amount == 0) return 1

        val key = Pair(amount, index)
        if (memorization[key] != null) return memorization[key]!!

        var combinations = 0
        for (i in index downTo 0) {
            val newAmount = amount - coins[i]

            combinations += change(newAmount, i, coins)
        }

        memorization[key] = combinations

        return combinations
    }

    fun clear() {
        memorization.clear()
    }
}

fun main(args: Array<String>) {
    val solution = CoinChange2()
    val example1 = solution.change(5, intArrayOf(1, 2, 5))
    assertEquals(4, example1)
    solution.clear()

    val example2 = solution.change(3, intArrayOf(2))
    assertEquals(0, example2)
    solution.clear()

    val example3 = solution.change(10, intArrayOf(10))
    assertEquals(1, example3)
}