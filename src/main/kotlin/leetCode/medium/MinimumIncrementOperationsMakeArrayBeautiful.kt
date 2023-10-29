package leetCode.medium

import java.util.Collections
import java.util.PriorityQueue

class MinimumIncrementOperationsMakeArrayBeautiful {
    data class Pair(
        val index: Int,
        val num: Int
    ) : Comparable<Pair> {
        override fun compareTo(other: Pair): Int {
            return if (num == other.num) {
                index.compareTo(other.index)
            } else {
                num.compareTo(other.num)
            }
        }
    }

    fun minIncrementOperations(nums: IntArray, k: Int): Long {
        var left = 0
        var right = 0

        var result = 0L
        val priorityQueue = PriorityQueue<Pair>(Collections.reverseOrder())

        while (right < nums.size) {
            priorityQueue.add(Pair(right, nums[right]))

            if (priorityQueue.size == 3) {
                val polled = priorityQueue.poll()

                val newElement = if (polled.num < k) {
                    val diff = k - polled.num
                    result += diff
                    k
                } else {
                    polled.num
                }

                if (polled.index != left) {
                    priorityQueue.add(Pair(polled.index, newElement))
                    nums[polled.index] = newElement
                }
                priorityQueue.remove(Pair(left, nums[left]))
                left++
            }

            right++
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = MinimumIncrementOperationsMakeArrayBeautiful()
//    println(solution.minIncrementOperations(intArrayOf(2, 3, 0, 0, 2), 4))
//    println(solution.minIncrementOperations(intArrayOf(0,1,3,3), 5))
//    println(solution.minIncrementOperations(intArrayOf(1,1,2), 1))
//    println(solution.minIncrementOperations(intArrayOf(7, 7, 2, 7), 9))
    println(solution.minIncrementOperations(intArrayOf(43, 31, 14, 4), 73)) //42
}