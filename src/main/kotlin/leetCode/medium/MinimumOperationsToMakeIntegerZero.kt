package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import java.lang.Long

class MinimumOperationsToMakeIntegerZero {
    fun makeTheIntegerZero(num1: Int, num2: Int): Int {
        if (num2 > num1) return -1

        var highestDigit = 0
        var temp = num1
        while (temp > 0) {
            temp = temp.shr(1)
            highestDigit++
        }

        for (i in 0 until 61) {
            val target = num1 - i * num2.toLong()

            val bitsCount = Long.bitCount(target)

            if (target >= 0 && bitsCount <= i && i <= target) {
                return i
            }
        }

        return -1
    }
}

fun main(args: Array<String>) {
    val solution = MinimumOperationsToMakeIntegerZero()
    val example1 = solution.makeTheIntegerZero(3, -2)
    assertEquals(3, example1)

    val example2 = solution.makeTheIntegerZero(5, 7)
    assertEquals(-1, example2)
}