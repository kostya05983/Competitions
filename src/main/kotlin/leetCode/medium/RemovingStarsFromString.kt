package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class RemovingStarsFromString {
    fun removeStars(s: String): String {
        val sb = StringBuilder()

        for (ch in s) {
            when (ch) {
                '*' -> sb.deleteCharAt(sb.length - 1)
                else -> sb.append(ch)
            }
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val solution = RemovingStarsFromString()
    val example1 = solution.removeStars("leet**cod*e")
    assertEquals("lecoe", example1)

    val example2 = solution.removeStars("erase*****")
    assertEquals("", example2)
}