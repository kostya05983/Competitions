package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class GreatestCommonDivisorStrings {
    private fun gcd(x: Int, y: Int): Int {
        return if (y == 0) {
            x
        } else {
            gcd(y, x.rem(y))
        }
    }

    fun gcdOfStrings(str1: String, str2: String): String {
        if ((str1 + str2) != (str2 + str1)) return ""

        val gcdLength = gcd(str1.length, str2.length)
        return str1.substring(0, gcdLength)
    }
}

fun main(args: Array<String>) {
    val solution = GreatestCommonDivisorStrings()
    val example1 = solution.gcdOfStrings("ABCABC", "ABC")
    assertEquals("ABC", example1)

    val example2 = solution.gcdOfStrings("ABABAB", "ABAB")
    assertEquals("AB", example2)

    val example3 = solution.gcdOfStrings("LEET", "CODE")
    assertEquals("", example3)

    val example4 = solution.gcdOfStrings("ABCDEF", "ABC")
    assertEquals("", example4)
}