package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class LengthOfLongestAlphabeticalContinuousSubstring {
    fun longestContinuousSubstring(s: String): Int {
        var result = 1

        var count = 1
        for (i in 1 until s.length) {
            if (s[i] - s[i - 1] == 1) {
                count++
            } else {
                result = maxOf(result, count)
                count = 1
            }
        }
        result = maxOf(result, count)

        return result
    }
}

fun main(args: Array<String>) {
    val solution = LengthOfLongestAlphabeticalContinuousSubstring()
    val example1 = solution.longestContinuousSubstring("abacaba")
    assertEquals(2, example1)

    val example2 = solution.longestContinuousSubstring("abcde")
    assertEquals(5, example2)
}