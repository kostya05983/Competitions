package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.PriorityQueue
import kotlin.math.abs

class PathWithMinimumEffort {
    private val DIR = intArrayOf(0, 1, 0, -1, 0)

    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val distance = Array(heights.size) { IntArray(heights[0].size) { Int.MAX_VALUE } }

        val minHeap = PriorityQueue<IntArray> { o1, o2 -> o1[0].compareTo(o2[0]) }
        minHeap.offer(intArrayOf(0, 0, 0))
        distance[0][0] = 0

        while (!minHeap.isEmpty()) {
            val top = minHeap.poll()
            val d = top[0]
            val row = top[1]
            val col = top[2]
            if (d > distance[row][col]) continue
            if (row == heights.size - 1 && col == heights[0].size - 1) return d

            for (i in 0 until 4) {
                val nr = row + DIR[i]
                val nc = col + DIR[i + 1]

                if (nr >= 0 && nr < heights.size && nc >= 0 && nc < heights[0].size) {
                    val newDistance = maxOf(d, abs(heights[nr][nc] - heights[row][col]))
                    if (distance[nr][nc] > newDistance) {
                        distance[nr][nc] = newDistance
                        minHeap.offer(intArrayOf(distance[nr][nc], nr, nc))
                    }
                }
            }

        }

        return 0
    }
}

fun main(args: Array<String>) {
    val solution = PathWithMinimumEffort()
    val example1 = solution.minimumEffortPath(arrayOf(intArrayOf(1, 2, 2), intArrayOf(3, 8, 2), intArrayOf(5, 3, 5)))
    assertEquals(2, example1)

    val example2 = solution.minimumEffortPath(arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 8, 4), intArrayOf(5, 3, 5)))
    assertEquals(1, example2)

    val example3 = solution.minimumEffortPath(
        arrayOf(
            intArrayOf(1, 2, 1, 1, 1),
            intArrayOf(1, 2, 1, 2, 1),
            intArrayOf(1, 2, 1, 2, 1),
            intArrayOf(1, 2, 1, 2, 1),
            intArrayOf(1, 1, 1, 2, 1)
        )
    )
    assertEquals(0, example3)
}