package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.*

class RemoveDuplicateLetters {

    fun removeDuplicateLetters(s: String): String {
        val lastIndex = IntArray(26)

        for (i in s.indices) {
            lastIndex[s[i] - 'a'] = i
        }

        val seen = BooleanArray(26)
        val stack = Stack<Int>()

        for (i in s.indices) {
            val current = s[i] - 'a'
            if (seen[current]) continue

            while (!stack.isEmpty() && stack.peek() > current && i < lastIndex[stack.peek()]) {
                seen[stack.pop()] = false
            }

            stack.push(current)
            seen[current] = true
        }

        return stack.asSequence().map { Char(it.plus('a'.code)) }.joinToString("")
    }
}

fun main(args: Array<String>) {
    val solution = RemoveDuplicateLetters()
    val example1 = solution.removeDuplicateLetters("bcabc")
    assertEquals("abc", example1)

    val example2 = solution.removeDuplicateLetters("cbacdcbc")
    assertEquals("acdb", example2)

    val example3 = solution.removeDuplicateLetters("abcabc")
    assertEquals("abc", example3)

    val example4 = solution.removeDuplicateLetters("aaaaadddddbbbb")
    assertEquals("adb", example4)

    val example5 = solution.removeDuplicateLetters("ecbacba")
    assertEquals("eacb", example5)
}