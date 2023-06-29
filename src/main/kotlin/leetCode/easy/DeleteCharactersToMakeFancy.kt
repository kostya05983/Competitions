package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals
import java.lang.StringBuilder

class DeleteCharactersToMakeFancy {
    fun makeFancyString(s: String): String {
        val sb = StringBuilder()
        var count = 1
        var currentCh = s[0]
        sb.append(currentCh)

        for (i in 1 until s.length) {
            if (currentCh != s[i]) {
                currentCh = s[i]
                count = 0
            }
            count++
            if (count > 2) {
                continue
            }

            sb.append(s[i])
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val solution = DeleteCharactersToMakeFancy()
    val example1 = solution.makeFancyString("leeetcode")
    assertEquals("leetcode", example1)

    val example2 = solution.makeFancyString("aaabaaaa")
    assertEquals("aabaa", example2)

    val example3 = solution.makeFancyString("aab")
    assertEquals("aab", example3)
}