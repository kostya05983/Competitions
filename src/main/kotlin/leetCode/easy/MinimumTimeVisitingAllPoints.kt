package leetCode.easy

import kotlin.math.abs

class MinimumTimeVisitingAllPoints {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var pointerX = points[0][0]
        var pointerY = points[0][1]

        for (i in 1 until points.size) {
            val point = points[i]
            val diffX = pointerX - point[0]

        }
        TODO()
    }
}

fun main(args: Array<String>) {
    val solution = MinimumTimeVisitingAllPoints()
    println(solution.minTimeToVisitAllPoints(arrayOf(intArrayOf(1, 1), intArrayOf(3, 4), intArrayOf(-1, 0))))
    println(solution.minTimeToVisitAllPoints(arrayOf(intArrayOf(3, 2), intArrayOf(-2, 2))))
}