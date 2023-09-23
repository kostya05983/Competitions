package leetCode.easy

import org.junit.jupiter.api.Assertions.*

class BackSpaceStringCompare {
    fun backspaceCompare(s: String, t: String): Boolean {
        val sWithoutBackspaces = removeBackspaces(s)
        val tWithoutBackspaces = removeBackspaces(t)

        return sWithoutBackspaces == tWithoutBackspaces
    }

    private fun removeBackspaces(s: String): String {
        val sb = StringBuilder()

        for (ch in s) {
            when (ch) {
                '#' -> {
                    if (sb.isNotEmpty()) sb.deleteCharAt(sb.length - 1)
                }

                else -> {
                    sb.append(ch)
                }
            }
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val solution = BackSpaceStringCompare()
    val example1 = solution.backspaceCompare("ab#c", "ad#c")
    assertTrue(example1)

    val example2 = solution.backspaceCompare("ab##", "c#d#")
    assertTrue(example2)

    val example3 = solution.backspaceCompare("a#c", "b")
    assertFalse(example3)
}