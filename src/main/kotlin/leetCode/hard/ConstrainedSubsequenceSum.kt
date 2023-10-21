package leetCode.hard

import java.util.PriorityQueue

class ConstrainedSubsequenceSum {
    fun constrainedSubsetSum(nums: IntArray, k: Int): Int {
        val heap = PriorityQueue<IntArray>(Comparator { o1, o2 -> o2[0] - o1[0] })
        heap.add(intArrayOf(nums[0], 0))
        var result = nums[0]

        for (i in 1 until nums.size) {
            while (i - heap.peek()[1] > k) {
                heap.remove()
            }

            val current = maxOf(0, heap.peek()[0]) + nums[i]
            result = maxOf(result, current)
            heap.add(intArrayOf(current, i))
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = ConstrainedSubsequenceSum()
    println(solution.constrainedSubsetSum(intArrayOf(10, 2, -10, 5, 20), 2))
    println(solution.constrainedSubsetSum(intArrayOf(-1, -2, -3), 1))
    println(solution.constrainedSubsetSum(intArrayOf(10, -2, -10, -5, 20), 2))
}