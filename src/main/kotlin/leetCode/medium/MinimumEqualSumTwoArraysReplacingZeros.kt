package leetCode.medium

import kotlin.math.abs

class MinimumEqualSumTwoArraysReplacingZeros {
    fun minSum(nums1: IntArray, nums2: IntArray): Long {
        val (num1Sum, num1Zero) = sumAndZero(nums1)
        val (num2Sum, num2Zero) = sumAndZero(nums2)

        return when {
            num1Zero + num1Sum > num2Sum && num2Zero == 0L -> {
                return -1
            }

            num2Zero + num2Sum > num1Sum && num1Zero == 0L -> {
                return -1
            }

            num1Zero > num2Zero || num1Zero < num2Zero -> {
                return maxOf(num1Sum + num1Zero, num2Sum + num2Zero)
            }

            num1Zero == num2Zero -> {
                return maxOf(num1Sum, num2Sum) + num1Zero
            }

            else -> throw IllegalArgumentException("Strange case")
        }
    }

    private fun sumAndZero(nums: IntArray): Pair<Long, Long> {
        var countZeros = 0L
        var sum = 0L

        for (num in nums) {
            sum += num
            if (num == 0) countZeros++
        }

        return sum to countZeros
    }
}

fun main(args: Array<String>) {
    val solution = MinimumEqualSumTwoArraysReplacingZeros()
    println(solution.minSum(intArrayOf(3, 2, 0, 1, 0), intArrayOf(6, 5, 0)))
    println(solution.minSum(intArrayOf(2, 0, 2, 0), intArrayOf(1, 4)))
    println(solution.minSum(intArrayOf(3, 2, 0, 1, 0), intArrayOf(6, 5, 0, 0)))
    println(solution.minSum(intArrayOf(8, 4, 0, 1, 0), intArrayOf(6, 5, 0)))
    println(solution.minSum(intArrayOf(2, 0, 0), intArrayOf(4)))
    println(solution.minSum(intArrayOf(4), intArrayOf(2, 0, 0)))
    println(solution.minSum(intArrayOf(1, 4), intArrayOf(2, 0, 2, 0)))
    println(
        solution.minSum(
            intArrayOf(8, 13, 15, 18, 0, 18, 0, 0, 5, 20, 12, 27, 3, 14, 22, 0),
            intArrayOf(29, 1, 6, 0, 10, 24, 27, 17, 14, 13, 2, 19, 2, 11)
        )
    )
    println(
        solution.minSum(
            intArrayOf(20, 0, 18, 11, 0, 0, 0, 0, 0, 0, 17, 28, 0, 11, 10, 0, 0, 15, 29),
            intArrayOf(16, 9, 25, 16, 1, 9, 20, 28, 8, 0, 1, 0, 1, 27)
        )
    )
}

