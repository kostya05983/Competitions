package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals
import java.lang.StringBuilder

class ReverseVowelString {
    private val dictionary = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

    fun reverseVowels(s: String): String {
        val sb = StringBuilder(s)

        var left = 0
        var right = sb.length - 1
        while (left < right) {
            val leftCh = sb[left]
            val rightCh = sb[right]

            val isLeftVowel = dictionary.contains(leftCh)
            val isRightVowel = dictionary.contains(rightCh)

            if (isLeftVowel && isRightVowel) {
                sb[right] = leftCh
                sb[left] = rightCh
                left++
                right--
            }
            if (!isLeftVowel) {
                left++
            }
            if (!isRightVowel) {
                right--
            }
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val solution = ReverseVowelString()
    val example1 = solution.reverseVowels("hello")
    assertEquals("holle", example1)

    val example2 = solution.reverseVowels("leetcode")
    assertEquals("leotcede", example2)

    val example3 = solution.reverseVowels("aiooa")
    assertEquals("aooia", example3)
}