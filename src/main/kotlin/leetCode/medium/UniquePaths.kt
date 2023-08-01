package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class UniquePaths {
    private val memo = mutableMapOf<Pair<Int, Int>, Int>()

    fun uniquePaths(m: Int, n: Int): Int {
        return backTracking(0, 0, m, n)
    }

    private fun backTracking(i: Int, j: Int, m: Int, n: Int): Int {
        var combinations = 0
        if (i == m - 1 && j == n - 1) return 1

        val key = Pair(i, j)
        val memorized = memo[key]
        if (memorized != null) return memorized

        combinations += if (i < m - 1) {
            backTracking(i + 1, j, m, n)
        } else 0
        combinations += if (j < n - 1) {
            backTracking(i, j + 1, m, n)
        } else 0

        memo[key] = combinations

        return combinations
    }

    fun clear() {
        memo.clear()
    }

}

fun main(args: Array<String>) {
    val solution = UniquePaths()
    val example1 = solution.uniquePaths(3, 7)
    assertEquals(28, example1)
    solution.clear()

    val example2 = solution.uniquePaths(3, 2)
    assertEquals(3, example2)
}