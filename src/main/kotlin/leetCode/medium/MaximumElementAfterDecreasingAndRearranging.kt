package leetCode.medium

import java.lang.Math.abs

class MaximumElementAfterDecreasingAndRearranging {
    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        arr.sort()

        arr[0] = 1
        var max = arr[0]

        for (i in 1 until arr.size) {
            if (abs(arr[i] - arr[i - 1]) > 1) {
                arr[i] = arr[i - 1] + 1
            }
            max = maxOf(arr[i], max)
        }

        return max
    }
}

fun main(args: Array<String>) {
    val solution = MaximumElementAfterDecreasingAndRearranging()
    println(solution.maximumElementAfterDecrementingAndRearranging(intArrayOf(2, 2, 1, 2, 1)))
    println(solution.maximumElementAfterDecrementingAndRearranging(intArrayOf(100, 1, 1000)))
    println(solution.maximumElementAfterDecrementingAndRearranging(intArrayOf(1, 2, 3, 4, 5)))
}