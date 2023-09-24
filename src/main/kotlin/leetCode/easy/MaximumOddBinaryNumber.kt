package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class MaximumOddBinaryNumber {

    fun maximumOddBinaryNumber(s: String): String {
        var oneCount = 0
        var zeroCount = 0

        for (ch in s) {
            when (ch) {
                '1' -> {
                    oneCount++
                }

                else -> {
                    zeroCount++
                }
            }
        }

        val sb = StringBuilder()

        while (oneCount > 0 || zeroCount > 0) {
            if (oneCount > 1) {
                sb.append('1')
                oneCount--
                continue
            }
            if (zeroCount > 0) {
                sb.append('0')
                zeroCount--
                continue
            }

            sb.append('1')
            oneCount--
        }

        return sb.toString()
    }

}

fun main(args: Array<String>) {
    val solution = MaximumOddBinaryNumber()
    val example1 = solution.maximumOddBinaryNumber("010")
    assertEquals("001", example1)

    val example2 = solution.maximumOddBinaryNumber("0101")
    assertEquals("1001", example2)
}