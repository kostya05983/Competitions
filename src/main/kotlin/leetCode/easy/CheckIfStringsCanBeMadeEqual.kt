package leetCode.easy

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import java.lang.StringBuilder

class CheckIfStringsCanBeMadeEqual {
    fun canBeEqual(s1: String, s2: String): Boolean {
        return handle(0, s1, s2)
    }

    private fun handle(index: Int, leftString: String, right: String): Boolean {
        val rightIndex = index + 2
        if (rightIndex >= leftString.length) return leftString == right

        val sb = StringBuilder(leftString)

        val old = sb[index]
        sb[index] = sb[rightIndex]
        sb[rightIndex] = old

        return handle(index + 1, sb.toString(), right).or(
            handle(index + 1, leftString, right)
        )
    }
}

fun main(args: Array<String>) {
    val solution = CheckIfStringsCanBeMadeEqual()

    val example1 = solution.canBeEqual("abcd", "cdab")
    assertTrue(example1)

    val example2 = solution.canBeEqual("abcd", "dacb")
    assertFalse(example2)
}