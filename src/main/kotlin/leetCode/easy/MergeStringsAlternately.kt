package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals
import java.lang.StringBuilder

class MergeStringsAlternately {
    fun mergeAlternately(word1: String, word2: String): String {
        var left = 0
        var right = 0

        val sb = StringBuilder()

        while (left < word1.length || right < word2.length) {
            if (left < word1.length) {
                sb.append(word1[left])
                left++
            }
            if (right < word2.length) {
                sb.append(word2[right])
                right++
            }
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val solution = MergeStringsAlternately()
    val example1 = solution.mergeAlternately("abc", "pqr")
    assertEquals("apbqcr", example1)

    val example2 = solution.mergeAlternately("ab", "pqrs")
    assertEquals("apbqrs", example2)

    val example3 = solution.mergeAlternately("abcd", "pq")
    assertEquals("apbqcd", example3)
}