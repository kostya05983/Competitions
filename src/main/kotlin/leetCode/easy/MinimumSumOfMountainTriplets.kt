package leetCode.easy

import kotlin.math.min

class MinimumSumOfMountainTriplets {
    fun minimumSum(nums: IntArray): Int {
        var minSum = Int.MAX_VALUE

        for (i in 0 until nums.size) {
            for (j in i + 1 until nums.size) {
                for (k in j + 1 until nums.size) {
                    if (nums[i] < nums[j] && nums[j] > nums[k])
                        minSum = minOf(minSum, nums[i] + nums[j] + nums[k])
                }
            }
        }

        return if (minSum == Int.MAX_VALUE) -1 else minSum
    }
}

fun main(args: Array<String>) {
    val solution = MinimumSumOfMountainTriplets()
    println(solution.minimumSum(intArrayOf(8, 6, 1, 5, 3)))
    println(solution.minimumSum(intArrayOf(5, 4, 8, 7, 10, 2)))
    println(solution.minimumSum(intArrayOf(6, 5, 4, 3, 4, 5)))
    println(solution.minimumSum(intArrayOf(5, 4, 8, 7, 10, 2, 3, 1)))
    println(solution.minimumSum(intArrayOf(9, 8, 7)))
    println(solution.minimumSum(intArrayOf(1, 7, 9)))
    println(solution.minimumSum(intArrayOf(2, 3, 2, 9, 9, 9)))
    println(solution.minimumSum(intArrayOf(2, 3, 2, 9, 9, 9, 1, 2, 1)))
//    println(solution.minimumSum(intArrayOf(2, 3, 2, 1)))

}

