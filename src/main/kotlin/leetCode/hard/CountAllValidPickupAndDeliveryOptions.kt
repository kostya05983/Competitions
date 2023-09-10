package leetCode.hard

import org.junit.jupiter.api.Assertions.assertEquals

class CountAllValidPickupAndDeliveryOptions {
    /**
     * Spoiler
     * Try again
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */

    fun countOrders(n: Int): Int {
        if (n == 1) return 1

        val dp = LongArray(n + 1)

        val mod = Math.pow(10.0, 9.0) + 7

        dp[1] = 1
        dp[2] = 6

        for (i in 3..n) {
            val k = 2 * i - 1
            val possibility = k * (k + 1) / 2
            val res = possibility * dp[i - 1]
            dp[i] = (res % mod).toLong()
        }

        return dp[n].toInt()
    }
}

fun main(args: Array<String>) {
    val solution = CountAllValidPickupAndDeliveryOptions()
    val example1 = solution.countOrders(1)
    assertEquals(1, example1)

    val example2 = solution.countOrders(2)
    assertEquals(6, example2)

    val example3 = solution.countOrders(3)
    assertEquals(90, example3)
}