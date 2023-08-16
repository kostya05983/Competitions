package leetCode.hard

import java.util.Collections
import java.util.PriorityQueue

class SlidingWindowMax {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val result = IntArray(nums.size - k + 1)

        var i = 0
        val queue = PriorityQueue<Int>(Collections.reverseOrder())
        while (i < nums.size) {
            queue.add(nums[i])

            val index = i - k + 1
            if (i >= k - 1) {
                result[index] = queue.peek()
                queue.remove(nums[index])
            }

            i++
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = SlidingWindowMax()
    val example1 = solution.maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3)
    println(example1.toList())

    val example2 = solution.maxSlidingWindow(intArrayOf(1), 1)
    println(example2.toList())
}