package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class FindTheHighestAltitude {
    fun largestAltitude(gain: IntArray): Int {
        var max = 0

        var current = 0
        for (g in gain) {
            current += g
            max = maxOf(current, max)
        }

        return max
    }
}

fun main(args: Array<String>) {
    val solution = FindTheHighestAltitude()
    val example1 = solution.largestAltitude(intArrayOf(-5, 1, 5, 0, -7))
    assertEquals(1, example1)

    val example2 = solution.largestAltitude(intArrayOf(-4, -3, -2, -1, 4, 3, 2))
    assertEquals(0, example2)
}