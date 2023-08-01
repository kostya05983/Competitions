package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class PalindromicSubstrings {
    fun countSubstrings(s: String): Int {
        TODO()
    }
}

fun main(args: Array<String>) {
    val solution = PalindromicSubstrings()

    val example1 = solution.countSubstrings("abc")
    assertEquals(3, example1)

    val example2 = solution.countSubstrings("aaa")
    assertEquals(6, example2)
}