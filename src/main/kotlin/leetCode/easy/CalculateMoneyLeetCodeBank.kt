package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class CalculateMoneyLeetCodeBank {
    fun totalMoney(n: Int): Int {
        val d = 1
        var a1 = 1
        var total = 0

        for (i in 0 until n / 7) {
            total += countArithmeticSum(a1, d, 7)
            a1++
        }
        val rem = n.rem(7)
        if (rem != 0) {
            total += countArithmeticSum(a1, d, rem)
        }

        return total
    }

    private fun countArithmeticSum(a1: Int, d: Int, n: Int): Int {
        val an = a1 + d * (n - 1)
        return (a1 + an) * n / 2
    }
}

fun main(args: Array<String>) {
    val solution = CalculateMoneyLeetCodeBank()
    val example1 = solution.totalMoney(4)
    assertEquals(10, example1)

    val example2 = solution.totalMoney(10)
    assertEquals(37, example2)

    val example3 = solution.totalMoney(20)
    assertEquals(96, example3)
}