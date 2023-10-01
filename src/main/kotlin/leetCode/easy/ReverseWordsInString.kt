package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class ReverseWordsInString {
    fun reverseWords(s: String): String {
        val sb = StringBuilder(s)

        var right = s.length - 1
        var left = s.length - 1

        while (left >= 0) {
            val ch = s[left]

            if (ch == ' ' || left == 0) {
                var tempLeft = left + 1
                if (left == 0) tempLeft = 0

                while (tempLeft < right) {
                    val temp = sb[tempLeft]
                    sb[tempLeft] = sb[right]
                    sb[right] = temp

                    right--
                    tempLeft++
                }
                right = left - 1
            }
            left--
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val solution = ReverseWordsInString()
    val example1 = solution.reverseWords("Let's take LeetCode contest")
    assertEquals("s'teL ekat edoCteeL tsetnoc", example1)

    val example2 = solution.reverseWords("God Ding")
    assertEquals("doG gniD", example2)

    val example3 = solution.reverseWords("Don Don  ")
    assertEquals("noD noD  ", example3)
}