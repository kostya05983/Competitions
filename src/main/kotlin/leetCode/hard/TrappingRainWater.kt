package leetCode.hard

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.PriorityQueue

class TrappingRainWater {
    data class Pair(
        val first: Int,
        val second: Int
    ) : Comparable<Pair> {
        override fun compareTo(other: Pair): Int {
            return if (first == other.first) {
                other.second.compareTo(second)
            } else {
                first.compareTo(other.first)
            }
        }
    }

    fun trap(height: IntArray): Int {
        var left = height.indexOfFirst { it != 0 }
        if (left == -1) return 0

        var right = left + 1

        var result = 0

        var localResult = 0

        val minHeap = PriorityQueue<Pair>().also {
            it.add(Pair(height[left], left))
        }
        val countBlocks = IntArray(height.size)
        countBlocks[left] = height[left]

        val memory = mutableMapOf<Int, Int>()

        while (right < height.size) {
            val leftHeight = height[left]
            val rightHeight = height[right]
            countBlocks[right] = countBlocks[right - 1] + rightHeight

            if (rightHeight == 0) {
                right++
                minHeap.add(Pair(rightHeight, right))
                continue
            }
            if (rightHeight >= leftHeight) {
                result += (right - left - 1) * leftHeight - (countBlocks[right - 1] - countBlocks[left])
                left = right
                right++

                minHeap.clear()
                minHeap.add(Pair(rightHeight, left))
                localResult = 0
                continue
            }

            //Выкидываем, все элементы, которые меньше правой стены до последнего
            while (minHeap.size >= 1 && minHeap.peek().first < rightHeight) {
                val polled = minHeap.poll()
                val found = memory[polled.second]
                if (found != null) {
                    localResult -= found
                }
            }

            val leftWall = minHeap.peek()
            if (right - leftWall.second == 1) {
                minHeap.add(Pair(rightHeight, right))
                right++
                continue
            }

            val waterSize = (right - leftWall.second - 1) * rightHeight -
                    (countBlocks[right - 1] - countBlocks[leftWall.second])
            memory[right] = waterSize
            localResult += waterSize

            minHeap.add(Pair(rightHeight, right))
            right++
        }
        result += localResult

        return result
    }
}

fun main(args: Array<String>) {
    val solution = TrappingRainWater()
    assertEquals(6, solution.trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    assertEquals(9, solution.trap(intArrayOf(4, 2, 0, 3, 2, 5)))
    assertEquals(22, solution.trap(intArrayOf(12, 0, 10, 11, 0, 10)))
    assertEquals(3, solution.trap(intArrayOf(9, 6, 8, 8, 5, 6, 3)))
    assertEquals(33, solution.trap(intArrayOf(4, 3, 8, 3, 1, 5, 9, 9, 0, 4, 3, 4, 7)))
}