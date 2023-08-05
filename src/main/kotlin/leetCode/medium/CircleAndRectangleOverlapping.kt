package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.math.abs
import kotlin.math.max

class CircleAndRectangleOverlapping {
    fun checkOverlap(radius: Int, xCenter: Int, yCenter: Int, x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
        val diffX = when {
            xCenter < x1 -> x1 - xCenter
            xCenter > x2 -> xCenter - x2
            else -> 0
        }
        val diffY = when {
            yCenter < y1 -> y1 - yCenter
            yCenter > y2 -> yCenter - y2
            else -> 0
        }

        return (diffX * diffX + diffY * diffY) <= radius * radius
    }
}

fun main(args: Array<String>) {
    val solution = CircleAndRectangleOverlapping()
    val example1 = solution.checkOverlap(1, 0, 0, 1, -1, 3, 1)
    assertEquals(true, example1)

    val example2 = solution.checkOverlap(1, 1, 1, 1, -3, 2, -1)
    assertEquals(false, example2)

    val example3 = solution.checkOverlap(1, 0, 0, -1, 0, 0, 1)
    assertEquals(true, example3)

    val example4 = solution.checkOverlap(4, 102, 50, 0, 0, 100, 100)
    assertEquals(true, example4)

    val example5 = solution.checkOverlap(2, 3, 1, 0, 6, 1, 10)
    assertEquals(false, example5)

    val example6 = solution.checkOverlap(5, 8, 8, 9, 5, 12, 8)
    assertEquals(true, example6)

    val example7 = solution.checkOverlap(27, 0, 19, 22, 8, 28, 18)
    assertEquals(true, example7)

    val example8 = solution.checkOverlap(4, 9, 3, 1, 5, 2, 10)
    assertEquals(false, example8)

    val example9 = solution.checkOverlap(415, 523, 539, 26, 363, 193, 423)
    assertEquals(true, example9)
}