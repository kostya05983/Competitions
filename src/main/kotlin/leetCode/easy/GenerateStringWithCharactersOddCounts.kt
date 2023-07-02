package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class GenerateStringWithCharactersOddCounts {
    fun generateTheString(n: Int): String {
        val sb = StringBuilder()
        val firstLetter = 'a'
        val secondLetter = 'b'
        val thirdLetter = 'c'

        var remains = n
        sb.append(firstLetter)
        remains--

        if (remains.rem(2) == 0 && remains != 0) {
            sb.append(secondLetter)
            remains--
        }
        while (remains > 0) {
            sb.append(thirdLetter)
            remains--
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val solution = GenerateStringWithCharactersOddCounts()
    val example1 = solution.generateTheString(4)
    assertEquals("accc", example1)

    val example2 = solution.generateTheString(2)
    assertEquals("ac", example2)

    val example3 = solution.generateTheString(7)
    assertEquals("abccccc", example3)

    val example4 = solution.generateTheString(52)
    assertEquals("", example4)
}