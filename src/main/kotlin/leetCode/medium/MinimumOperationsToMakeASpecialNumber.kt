package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import java.lang.StringBuilder

class MinimumOperationsToMakeASpecialNumber {
    fun minimumOperations(num: String): Int {
        val lastNumZero = num.lastIndexOf("0")
        val lastNumFive = num.lastIndexOf("5")

        var min = Int.MAX_VALUE
        //zero case
        if (lastNumZero != -1) {
            val zeroSubstr = num.substring(0, lastNumZero)
            val previousZeroZero = zeroSubstr.lastIndexOf("0")
            val previousFiveZero = zeroSubstr.lastIndexOf("5")

            val zeroZero = if (previousZeroZero != -1) {
                (num.length - previousZeroZero)
            } else Int.MAX_VALUE

            val fiveZero = if (previousFiveZero != -1) {
                (num.length - previousFiveZero)
            } else Int.MAX_VALUE

            min = minOf(zeroZero, fiveZero, min)
        }

        //five case
        if (lastNumFive != -1) {
            val fiveSubstr = num.substring(0, lastNumFive)
            val previousTwoFive = fiveSubstr.lastIndexOf("2")
            val previousSevenFive = fiveSubstr.lastIndexOf("7")

            val twoFive = if (previousTwoFive != -1) {
                (num.length - previousTwoFive)
            } else Int.MAX_VALUE
            val sevenFive = if (previousSevenFive != -1) {
                (num.length - previousSevenFive)
            } else Int.MAX_VALUE

            min = minOf(twoFive, sevenFive, min)
        }

        return if (min == Int.MAX_VALUE) num.length - num.count { it == '0' } else min - 2
    }

    //00
    //25
    //50
    //75
}

fun main(args: Array<String>) {
    val solution = MinimumOperationsToMakeASpecialNumber()
    val example1 = solution.minimumOperations("2245047")
    assertEquals(2, example1)

    val example2 = solution.minimumOperations("2908305")
    assertEquals(3, example2)
//
    val example3 = solution.minimumOperations("10")
    assertEquals(1, example3)

    val example4 = solution.minimumOperations("2908205")
    assertEquals(1, example4)

    val example5 = solution.minimumOperations("2908005")
    assertEquals(1, example5)

    val example6 = solution.minimumOperations("1")
    assertEquals(1, example6)

    val example7 = solution.minimumOperations("11")
    assertEquals(2, example7)

    val example8 = solution.minimumOperations("20")
    assertEquals(1, example8)

    val example9 = solution.minimumOperations("25")
    assertEquals(0, example9)

    val example10 = solution.minimumOperations("2713539")
    assertEquals(4, example10)

    val example11 = solution.minimumOperations("820366")
    assertEquals(5, example11)
}