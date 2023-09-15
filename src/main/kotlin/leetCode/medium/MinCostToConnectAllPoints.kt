package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.PriorityQueue
import kotlin.math.abs

class MinCostToConnectAllPoints {
    data class Value(
        val distance: Int,
        val rightPoint: IntArray
    ) : Comparable<Value> {
        override fun compareTo(other: Value): Int {
            return distance.compareTo(other.distance)
        }
    }

    fun minCostConnectPoints(points: Array<IntArray>): Int {
        var result = 0
        val leftToRight = HashMap<IntArray, PriorityQueue<Value>>()

        for (i in points.indices) {
            for (j in points.indices) {
                if (i == j) continue
                val leftPoint = points[i]
                val rightPoint = points[j]

                val manhatan = manhatan(leftPoint, rightPoint)

                leftToRight[leftPoint] = leftToRight.getOrDefault(leftPoint, PriorityQueue()).also {
                    it.add(Value(manhatan, rightPoint))
                }
            }
        }

        val visited = HashSet<IntArray>().also {
            it.add(points[0])
        }

        while (visited.size != points.size) {
            var minLeft: IntArray? = null
            var minRight: IntArray? = null
            var min = Int.MAX_VALUE

            for (visit in visited) {
                val rightArray = leftToRight[visit]!!

                var minDistance = rightArray.peek()
                while (visited.contains(minDistance.rightPoint)) {
                    rightArray.poll()
                    minDistance = rightArray.peek()
                }

                if (minDistance.distance < min) {
                    min = minDistance.distance
                    minLeft = visit
                    minRight = minDistance.rightPoint
                }
            }

            leftToRight[minLeft]!!.poll()

            result += min
            visited.add(minLeft!!)
            visited.add(minRight!!)
        }

        return result
    }

    private fun manhatan(leftPoint: IntArray, rightPoint: IntArray): Int {
        return abs(leftPoint[0] - rightPoint[0]) + abs(leftPoint[1] - rightPoint[1])
    }
}

fun main(args: Array<String>) {
    val solution = MinCostToConnectAllPoints()
    val example1 = solution.minCostConnectPoints(
        arrayOf(
            intArrayOf(0, 0),
            intArrayOf(2, 2),
            intArrayOf(3, 10),
            intArrayOf(5, 2),
            intArrayOf(7, 0)
        )
    )
    assertEquals(20, example1)

    val example2 = solution.minCostConnectPoints(
        arrayOf(
            intArrayOf(3, 12),
            intArrayOf(-2, 5),
            intArrayOf(-4, 1)
        )
    )
    assertEquals(18, example2)

    val example3 = solution.minCostConnectPoints(
        arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 1),
            intArrayOf(1, 0),
            intArrayOf(-1, 1)
        )
    )
    assertEquals(4, example3)

    val example4 = solution.minCostConnectPoints(
        arrayOf(
            intArrayOf(7, 18),
            intArrayOf(-15, 19),
            intArrayOf(-18, -15),
            intArrayOf(-7, 14),
            intArrayOf(4, 1),
            intArrayOf(-6, 3)
        )
    )
    assertEquals(85, example4)
}