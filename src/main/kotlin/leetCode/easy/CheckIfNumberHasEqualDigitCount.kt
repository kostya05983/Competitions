package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class CheckIfNumberHasEqualDigitCount {
    fun digitCount(num: String): Boolean {
        val array = IntArray(10)

        for (i in num.indices) {
            val times = num[i] - '0'
            array[i] += times
            array[times] -= 1
        }

        return array.all { it == 0 }
    }
}

fun main(args: Array<String>) {
    val solution = CheckIfNumberHasEqualDigitCount()
    val example1 = solution.digitCount("1210")
    assertEquals(true, example1)

    val example2 = solution.digitCount("030")
    assertEquals(false, example2)
}