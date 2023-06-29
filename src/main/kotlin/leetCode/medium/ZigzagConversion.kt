package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class ZigzagConversion {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s
        if (s.length == numRows) return s

        val zigzagLength = 2 * numRows - 2
        val sb = StringBuilder()

        for (i in 0 until numRows) {
            var current = i

            while (current < s.length) {
                sb.append(s[current])
                if (i != 0 && i != numRows - 1) {
                    val index = current + zigzagLength - i * 2
                    if (index < s.length) sb.append(s[index])
                }
                current += zigzagLength
            }
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val solution = ZigzagConversion()

    val example1 = solution.convert("PAYPALISHIRING", 3)
    assertEquals("PAHNAPLSIIGYIR", example1)

    val example2 = solution.convert("PAYPALISHIRING", 4)
    assertEquals("PINALSIGYAHRPI", example2)

    val example3 = solution.convert("ABC", 2)
    assertEquals("ACB", example3)

    val example4 = solution.convert("ABCDEF", 5)
    assertEquals("ABCDFE", example4)
}