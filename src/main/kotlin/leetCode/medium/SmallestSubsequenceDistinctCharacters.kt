package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.*

class SmallestSubsequenceDistinctCharacters {
    fun smallestSubsequence(s: String): String {
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
    val solution = SmallestSubsequenceDistinctCharacters()
    assertEquals("abc", solution.smallestSubsequence("bcabc"))

    assertEquals("acdb", solution.smallestSubsequence("cbacdcbc"))
}