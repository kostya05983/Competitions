package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class MakeStringGreat {
    fun makeGood(s: String): String {
        val sb = StringBuilder()

        if (s.isEmpty()) return s

        var left = 0
        var right = 1
        while (left <= s.lastIndex) {
            if (right > s.lastIndex || !s[left].equals(s[right], ignoreCase = true) || s[left] == s[right]) {
                sb.append(s[left])

                left = right
                right++
                continue
            }
            if (sb.isEmpty()) {
                right++
                left = right
                right++
                continue
            }

            sb.setLength(sb.length - 1)
            left--
            right++
            if (left < 0) {
                left = right
                right++
            }
        }

        return sb.toString()
    }

    fun makeGoodSb(s: String): String {
        val sb = StringBuilder()

        if (s.isEmpty()) return s

        var i = 0
        while (i < s.length) {
            if (sb.isNotEmpty() && sb.last() != s[i] && sb.last().equals(s[i], ignoreCase = true)) {
                sb.setLength(sb.length - 1)
                i++
                continue
            }
            sb.append(s[i])
            i++
        }

        return sb.toString()
    }
}

//"abBAcC"
//aAcC
//
fun main(args: Array<String>) {
    val solution = MakeStringGreat()
    val example1 = solution.makeGoodSb("leEeetcode")
    assertEquals("leetcode", example1)

    val example2 = solution.makeGoodSb("abBAcC")
    assertEquals("", example2)

    val example3 = solution.makeGoodSb("NAanorRoOrROwnTNW")
    assertEquals("wnTNW", example3)
}