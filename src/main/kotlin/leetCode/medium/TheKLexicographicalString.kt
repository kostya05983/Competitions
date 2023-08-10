package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import java.lang.StringBuilder
import kotlin.math.ceil

class TheKLexicographicalString {
    private val abc = arrayOf('a', 'b', 'c')
    private val remainArrays = arrayOf(
        arrayOf('b', 'c'),
        arrayOf('a', 'c'),
        arrayOf('a', 'b')
    )

    fun getHappyString(n: Int, k: Int): String {
        val combinations = getCombinations(n)
        if (combinations < k) return ""

        val sb = StringBuilder(n)

        val happy = combinations / 3

        val index = ceil(k / (happy).toDouble()).toInt()

        var letter = abc[index - 1]
        sb.append(letter)

        val state2 = k - (index - 1) * happy - 1
        for (bitIndex in n - 2 downTo 0) {
            val upBit = state2.shr(bitIndex).and(1)
            letter = remainArrays[letter - 'a'][upBit]
            sb.append(letter)
        }

        return sb.toString()
    }

    private fun getCombinations(n: Int): Int {
        if (n == 1) return abc.size

        return 3 * 2.shl(n - 2)
    }
}

fun main(args: Array<String>) {
    val solution = TheKLexicographicalString()
    val example1 = solution.getHappyString(1, 3)
    assertEquals("c", example1)

    val example2 = solution.getHappyString(1, 4)
    assertEquals("", example2)

    val example3 = solution.getHappyString(3, 9)
    assertEquals("cab", example3)

    val example4 = solution.getHappyString(10, 100)
    assertEquals("abacbabacb", example4)
}