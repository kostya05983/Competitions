package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class CanPlaceFlowers {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var count = 0
        for (i in flowerbed.indices) {
            val previous = flowerbed.getOrElse(i - 1) { 0 }
            val current = flowerbed[i]
            val next = flowerbed.getOrElse(i + 1) { 0 }

            if (previous != 1 && next != 1 && current == 0) {
                flowerbed[i] = 1
                count++
            }
        }

        return count >= n
    }
}

fun main(args: Array<String>) {
    val solution = CanPlaceFlowers()
    val example1 = solution.canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 1)
    assertEquals(true, example1)

    val example2 = solution.canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 2)
    assertEquals(false, example2)
}