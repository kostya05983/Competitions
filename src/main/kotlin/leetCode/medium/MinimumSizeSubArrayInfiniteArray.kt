package leetCode.medium

import java.util.*

class MinimumSizeSubArrayInfiniteArray {

    fun minSizeSubarray(nums: IntArray, target: Int): Int {
        var left = 0
        var right = 0

        var sum = 0
        var count = 0
        val heap = PriorityQueue<Int>()
        while (left < nums.size) {
            if (right == nums.size) {
                right = 0
            }

            sum += nums[right]
            count++

            while (sum > target && left < nums.size) {
                sum -= nums[left]
                left++
                count--

                if (sum == target) {
                    heap.add(count)
                }
            }

            when (sum) {
                target -> {
                    heap.add(count)
                }

                else -> {
                }
            }

            right++
        }

        return if (heap.isEmpty()) -1 else heap.peek()
    }
}

fun main(args: Array<String>) {
    val solution = MinimumSizeSubArrayInfiniteArray()

    val example = solution.minSizeSubarray(intArrayOf(1, 1, 1, 2, 3), 4)
    println(example)

    val example2 = solution.minSizeSubarray(intArrayOf(2, 1, 5, 7, 7, 1, 6, 3), 39)
    println(example2)
}