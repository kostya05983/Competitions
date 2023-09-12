package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class LastMomentAllAntsFallOutPlank {
    fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int {
        val max = left.maxOrNull() ?: 0
        val min = right.minOrNull() ?: n

        return maxOf(max, n - min)
    }
}

fun main(args: Array<String>) {
    val solution = LastMomentAllAntsFallOutPlank()
    val example1 = solution.getLastMoment(4, intArrayOf(4, 3), intArrayOf(0, 1))
    assertEquals(4, example1)

    val example2 = solution.getLastMoment(7, intArrayOf(), intArrayOf(0, 1, 2, 3, 4, 5, 6, 7))
    assertEquals(7, example2)

    val example3 = solution.getLastMoment(7, intArrayOf(0, 1, 2, 3, 4, 5, 6, 7), intArrayOf())
    assertEquals(7, example3)
}