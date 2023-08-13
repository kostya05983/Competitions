package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.Stack

class DecryptStringFromAlphabetToInteger {
    fun freqAlphabets(s: String): String {
        val stack = Stack<Char>()
        var i = s.length - 1
        while (i >= 0) {
            val ch = s[i]

            if (ch == '#') {
                i -= 2
                stack.add('j' + "${s[i]}${s[i + 1]}".toInt() - 10)
            } else {
                stack.add('a' + ch.toString().toInt() - 1)
            }
            i--
        }

        val sb = StringBuilder()
        while(stack.isNotEmpty()) {
            sb.append(stack.pop())
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val solution = DecryptStringFromAlphabetToInteger()
    val example1 = solution.freqAlphabets("10#11#12")
    assertEquals("jkab", example1)

    val example2 = solution.freqAlphabets("1326#")
    assertEquals("acz", example2)
}