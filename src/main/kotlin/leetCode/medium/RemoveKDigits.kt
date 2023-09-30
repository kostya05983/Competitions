package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import java.lang.StringBuilder
import java.util.Stack

class RemoveKDigits {
    fun removeKdigits(num: String, k: Int): String {
        val monotonicStack = Stack<Int>()

        var remainK = k

        for (ch in num) {
            val n = ch - '0'
            while (monotonicStack.isNotEmpty() && monotonicStack.peek() > n && remainK > 0) {
                monotonicStack.pop()
                remainK--
            }
            monotonicStack.push(n)
        }

        while (monotonicStack.isNotEmpty() && remainK > 0) {
            monotonicStack.pop()
            remainK--
        }

        if (monotonicStack.all { it == 0 }) return "0"

        val sb = StringBuilder()
        var wasNumber = false
        for (item in monotonicStack) {
            if (item > 0) wasNumber = true
            if (item == 0 && !wasNumber) continue

            sb.append(item)
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val solution = RemoveKDigits()
    val example1 = solution.removeKdigits("1432219", 3)
    assertEquals("1219", example1)

    val example2 = solution.removeKdigits("10200", 1)
    assertEquals("200", example2)

    val example3 = solution.removeKdigits("10", 2)
    assertEquals("0", example3)

    val example4 = solution.removeKdigits("10200", 2)
    assertEquals("0", example4)

    val example5 = solution.removeKdigits("9", 1)
    assertEquals("0", example5)

    val example6 = solution.removeKdigits("112", 1)
    assertEquals("11", example6)
}