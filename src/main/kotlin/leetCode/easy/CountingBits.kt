package leetCode.easy

import org.junit.jupiter.api.Assertions.assertArrayEquals

class CountingBits {
    fun countBits(n: Int): IntArray {
        val result = IntArray(n + 1)
        for (i in 0..n) {
            result[i] = result[i / 2] + i.rem(2)
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = CountingBits()
    val example1 = solution.countBits(2)
    assertArrayEquals(intArrayOf(0, 1, 1), example1)

    val example2 = solution.countBits(5)
    assertArrayEquals(intArrayOf(0, 1, 1, 2, 1, 2), example2)
}