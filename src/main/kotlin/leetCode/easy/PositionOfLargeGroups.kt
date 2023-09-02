package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

class PositionOfLargeGroups {
    fun largeGroupPositions(s: String): List<List<Int>> {
        var left = 0
        var right = 1

        val result = ArrayList<List<Int>>()
        while (right < s.length) {
            if (s[right] != s[left]) {
                if (right - left >= 3) result.add(listOf(left, right - 1))
                left = right
            }
            right++
        }
        if (right - left >= 3) result.add(listOf(left, right - 1))

        return result
    }
}

fun main(args: Array<String>) {
    val solution = PositionOfLargeGroups()
    val example1 = solution.largeGroupPositions("abbxxxxzzy")
    println(example1)

    val example2 = solution.largeGroupPositions("abc")
    assertTrue(example2.isEmpty())

    val example3 = solution.largeGroupPositions("abcdddeeeeaabbbcd")
    println(example3)

    val example4 = solution.largeGroupPositions("aaa")
    println(example4)
}