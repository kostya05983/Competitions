package leetCode.easy

import kotlin.math.abs

class MinimumTimeVisitingAllPoints {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var pointerX = points[0][0]
        var pointerY = points[0][1]

        var result = 0
        for (i in 1 until points.size) {
            val point = points[i]

            while (point[0] != pointerX || point[1] != pointerY) {
                val diffX = point[0] - pointerX
                val diffY = point[1] - pointerY
                val min = minOf(abs(diffX), abs(diffY))

                when {
                    diffX > 0 && diffY > 0 -> {
                        //right up in diagonal
                        pointerX += min
                        pointerY += min
                    }

                    diffX < 0 && diffY > 0 -> {
                        //left up in diagonal
                        pointerX -= min
                        pointerY += min
                    }

                    diffX > 0 && diffY < 0 -> {
                        //right down in diagonal
                        pointerX += min
                        pointerY -= min
                    }

                    diffX < 0 && diffY < 0 -> {
                        //left down in diagonal
                        pointerX -= min
                        pointerY -= min
                    }

                    else -> {
                        if (diffX != 0) {
                            pointerX = point[0]
                            result += abs(diffX)
                        } else {
                            pointerY = point[1]
                            result += abs(diffY)
                        }
                    }
                }
                result += min
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = MinimumTimeVisitingAllPoints()
    println(solution.minTimeToVisitAllPoints(arrayOf(intArrayOf(1, 1), intArrayOf(3, 4), intArrayOf(-1, 0))))
    println(solution.minTimeToVisitAllPoints(arrayOf(intArrayOf(3, 2), intArrayOf(-2, 2))))
}