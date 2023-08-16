package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class FindTheIndexOfFirstOccurence {
    fun strStr(haystack: String, needle: String): Int {
        var left = 0
        var right = 0

        while (left < haystack.length) {
            val ch = haystack[left]

            val viewed = left - right

            if (ch == needle[right]) {
                right++
            } else {
                left -= right
                right = 0
            }
            if (right == needle.length) return viewed
            left++
        }

        return -1
    }
}

fun main(args: Array<String>) {
    val solution = FindTheIndexOfFirstOccurence()
    val example1 = solution.strStr("sadbutsad", "sad")
    assertEquals(0, example1)

    val example2 = solution.strStr("leetcode", "leeto")
    assertEquals(-1, example2)

    val example3 = solution.strStr("a", "a")
    assertEquals(0, example3)

    val example4 = solution.strStr("mississippi", "issip")
    assertEquals(4, example4)
}