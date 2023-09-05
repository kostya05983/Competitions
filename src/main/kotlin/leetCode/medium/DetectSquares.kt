package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.math.abs

class DetectSquares() {
    private val points = mutableMapOf<Int, MutableMap<Int, Int>>()

    fun add(point: IntArray) {
        val value = points.getOrDefault(point[0], mutableMapOf())
        value[point[1]] = value.getOrDefault(point[1], 0) + 1

        points[point[0]] = value
    }

    fun count(point: IntArray): Int {
        val (x, y) = point
        var result = 0

        val pointYMap = points[x] ?: return 0

        for ((pointY, count) in pointYMap) {
            val point1 = intArrayOf(x, pointY)

            if (pointY == y) continue

            val length = abs(y - pointY)

            result += count * countIntersects(point, intArrayOf(point1[0] + length, point1[1]))
            result += count * countIntersects(point, intArrayOf(point1[0] - length, point1[1]))
        }

        return result
    }

    private fun get(point: IntArray): Int {
        return points[point[0]]?.get(point[1]) ?: return 0
    }

    private fun countIntersects(zeroPoint: IntArray, secondPoint: IntArray): Int {
        return get(secondPoint) * get(intArrayOf(secondPoint[0], zeroPoint[1]))
    }
}

fun main(args: Array<String>) {
    val solution = DetectSquares()
    solution.add(intArrayOf(3, 10))
    solution.add(intArrayOf(11, 2))
    solution.add(intArrayOf(3, 2))
    val example1 = solution.count(intArrayOf(11, 10))
    assertEquals(1, example1)

    val example2 = solution.count(intArrayOf(14, 8))
    assertEquals(0, example2)

    solution.add(intArrayOf(11, 2))

    val example3 = solution.count(intArrayOf(11, 10))
    assertEquals(2, example3)
}