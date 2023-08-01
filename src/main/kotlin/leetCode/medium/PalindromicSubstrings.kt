package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class PalindromicSubstrings {
    fun countSubstrings(s: String): Int {
        var count = 0

        for (i in s.indices) {
            var left = i
            var right = i

            while (left >= 0 && right < s.length && s[left] == s[right]) {
                left--
                right++
                count++
            }

            left = i
            right = i + 1
            while (left >= 0 && right < s.length && s[left] == s[right]) {
                left--
                right++
                count++
            }
        }

        return count
    }
}

fun main(args: Array<String>) {
    val solution = PalindromicSubstrings()

    val example1 = solution.countSubstrings("abc")
    assertEquals(3, example1)

    val example2 = solution.countSubstrings("aaa")
    assertEquals(6, example2)
}