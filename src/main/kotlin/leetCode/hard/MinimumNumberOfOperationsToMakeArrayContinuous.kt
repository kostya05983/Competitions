package leetCode.hard

import java.util.Deque
import java.util.ArrayDeque

class MinimumNumberOfOperationsToMakeArrayContinuous {

    fun minOperations(nums: IntArray): Int {
        nums.sort()

        val n = nums.size
        var maxWindowSize = 0

        val windowNums: Deque<Int> = ArrayDeque()
        for (num in nums) {
            while (windowNums.isNotEmpty() && num - windowNums.peekFirst() >= n) {
                windowNums.poll()
            }

            while (windowNums.size == 0 || windowNums.peekLast() != num) {
                windowNums.offer(num)
            }

            maxWindowSize = maxOf(maxWindowSize, windowNums.size)
        }

        return n - maxWindowSize
    }
}

fun main(args: Array<String>) {
    val solution = MinimumNumberOfOperationsToMakeArrayContinuous()
    println(solution.minOperations(intArrayOf(4, 2, 5, 3)))
    println(solution.minOperations(intArrayOf(1, 2, 3, 5, 6)))
    println(solution.minOperations(intArrayOf(1, 10, 100, 1000)))
    println(solution.minOperations(intArrayOf(1, 2, 3, 4, 5, 10, 100, 110, 120, 130, 140)))
    println(solution.minOperations(intArrayOf(8, 5, 9, 9, 8, 4)))
    println(solution.minOperations(intArrayOf(6,5,7,7,6,4, 100, 120, 130)))
    println(solution.minOperations(intArrayOf(41, 33, 29, 33, 35, 26, 47, 24, 18, 28)))
}