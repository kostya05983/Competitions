package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class MinimumTotalSpaceWastedKResizing {
    fun minSpaceWastedKResizing(nums: IntArray, k: Int): Int {
        TODO()
    }
}

fun main(args: Array<String>) {
    val solution = MinimumTotalSpaceWastedKResizing()
    val example1 = solution.minSpaceWastedKResizing(intArrayOf(10, 20), 0)
    assertEquals(10, example1)

    val example2 = solution.minSpaceWastedKResizing(intArrayOf(10, 20, 30), 1)
    assertEquals(10, example2)

    val example3 = solution.minSpaceWastedKResizing(intArrayOf(10, 20, 15, 30, 20), 2)
    assertEquals(15, example3)
}