package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class MakeTwoArraysEqualByReversing {
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        val frequencies = mutableMapOf<Int, Int>()

        for (value in target) {
            frequencies[value] = 1 + frequencies.getOrDefault(value, 0)
        }

        for (n in arr) {
            val value = frequencies[n]
            if (value == null || value == 0) return false
            frequencies[n] = value - 1
        }
        return true
    }
}

fun main(args: Array<String>) {
    val solution = MakeTwoArraysEqualByReversing()
    val example1 = solution.canBeEqual(intArrayOf(1, 2, 3, 4), intArrayOf(2, 4, 1, 3))
    assertEquals(true, example1)

    val example2 = solution.canBeEqual(intArrayOf(7), intArrayOf(7))
    assertEquals(true, example2)

    val example3 = solution.canBeEqual(intArrayOf(3, 7, 9), intArrayOf(3, 7, 11))
    assertEquals(false, example3)

    val example4 = solution.canBeEqual(intArrayOf(1, 2, 2, 3), intArrayOf(1, 1, 2, 3))
    assertEquals(false, example4)
}