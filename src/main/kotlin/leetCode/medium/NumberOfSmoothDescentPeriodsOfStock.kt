package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class NumberOfSmoothDescentPeriodsOfStock {

    fun getDescentPeriods(prices: IntArray): Long {
        var result = 0L

        var i = 0
        var descent = 1
        while (i < prices.size) {
            if (i < prices.size - 1 && prices[i] - prices[i + 1] == 1) {
                descent++
            } else {
                result += descent + (descent.toLong() * (descent - 1) / 2)

                descent = 1
            }
            i++
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = NumberOfSmoothDescentPeriodsOfStock()
    val example1 = solution.getDescentPeriods(intArrayOf(3, 2, 1, 4))
    assertEquals(7, example1)

    val example2 = solution.getDescentPeriods(intArrayOf(8, 6, 7, 7))
    assertEquals(4, example2)

    val example3 = solution.getDescentPeriods(intArrayOf(1))
    assertEquals(1, example3)
}