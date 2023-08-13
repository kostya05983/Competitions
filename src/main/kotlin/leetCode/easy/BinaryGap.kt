package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals
import java.lang.StringBuilder

class BinaryGap {
    fun binaryGap(n: Int): Int {
        val binaryString = intToBinary(n)

        var counter = 1
        var max = 0
        for (i in 1 until binaryString.length) {
            val digit = binaryString[i]
            if (digit == '1') {
                max = maxOf(counter, max)
                counter = 1
            } else {
                counter++
            }
        }

        return max
    }

    private fun intToBinary(n: Int): String {
        val sb = StringBuilder()
        var remain = n
        while (remain > 0) {
            sb.append(remain.rem(2))
            remain /= 2
        }

        return sb.reverse().toString()
    }
}

fun main(args: Array<String>) {
    val solution = BinaryGap()
    val example1 = solution.binaryGap(22)
    assertEquals(2, example1)

    val example2 = solution.binaryGap(8)
    assertEquals(0, example2)

    val example3 = solution.binaryGap(5)
    assertEquals(2, example3)
}