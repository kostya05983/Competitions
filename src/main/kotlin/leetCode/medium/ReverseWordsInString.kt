package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import java.lang.StringBuilder
import java.util.Stack

class ReverseWordsInString {
    fun reverseWords(s: String): String {
        val splitted = s.trim().split(" ")

        val stack = Stack<String>()
        for (split in splitted) if (split.isNotBlank()) stack.push(split)

        val sb = StringBuilder()
        while (stack.isNotEmpty()) {
            sb.append(stack.pop())
            if (stack.size != 0) {
                sb.append(" ")
            }
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val solution = ReverseWordsInString()
    val example1 = solution.reverseWords("the sky is blue")
    assertEquals("blue is sky the", example1)

    val example2 = solution.reverseWords("  hello world  ")
    assertEquals("world hello", example2)

    val example3 = solution.reverseWords("a good   example")
    assertEquals("example good a", example3)
}