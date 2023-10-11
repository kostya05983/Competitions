package leetCode.hard

import kotlin.math.min

class ShortestSubArrayWithSumAtLeastK {
    fun shortestSubarray(nums: IntArray, k: Int): Int {
        var prefixSum = 0
        var minLength = Int.MAX_VALUE

        var right = 0
        var left = 0

        while (right < nums.size) {
            prefixSum += nums[right]

            when {
                prefixSum == k -> {
                    minLength = minOf(right - left + 1, minLength)
                    right++
                }

                prefixSum < k -> {
                    right++
                    while (nums[left] < 0) {
                        prefixSum -= nums[left]
                        left++
                    }
                }

                prefixSum > k -> {
                    prefixSum -= nums[left]
                    minLength = minOf(right - left + 1, minLength)
                    left++
                    if (prefixSum >= k) minLength = minOf(right - left + 1, minLength)
                    right++
                }
            }
        }

        return if (minLength == Int.MAX_VALUE) -1 else minLength
    }
}

fun main(args: Array<String>) {
    val solution = ShortestSubArrayWithSumAtLeastK()
//    println(solution.shortestSubarray(intArrayOf(1), 1))
//    println(solution.shortestSubarray(intArrayOf(1, 2), 4))
//    println(solution.shortestSubarray(intArrayOf(2, -1, 2), 3))
//    println(solution.shortestSubarray(intArrayOf(77, 19, 35, 10, -14), 19))
//    println(solution.shortestSubarray(intArrayOf(48, 99, 37, 4, -31), 140))
//    println(solution.shortestSubarray(intArrayOf(17, 85, 93, -45, -21), 150))
    println(solution.shortestSubarray(intArrayOf(84, -37, 32, 40, 95), 167))
}