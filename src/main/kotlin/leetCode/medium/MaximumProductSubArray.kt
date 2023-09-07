package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.math.max

class MaximumProductSubArray {

    fun maxProduct(nums: IntArray): Int {
        var maxProduct = nums[0]
        var minProduct = nums[0]
        var result = nums[0]

        for (i in 1 until nums.size) {
            if (nums[i] < 0) {
                val temp = maxProduct
                maxProduct = minProduct
                minProduct = temp
            }

            maxProduct = maxOf(nums[i], maxProduct * nums[i])
            minProduct = minOf(nums[i], minProduct * nums[i])

            result = maxOf(result, maxProduct)
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = MaximumProductSubArray()
    assertEquals(6, solution.maxProduct(intArrayOf(2, 3, -2, 4)))
//
    assertEquals(0, solution.maxProduct(intArrayOf(-2, 0, -1)))

    assertEquals(-2, solution.maxProduct(intArrayOf(-2)))
//
    assertEquals(2, solution.maxProduct(intArrayOf(0, 2)))

    assertEquals(224, solution.maxProduct(intArrayOf(1, 2, 3, 0, 4, 7, 8)))

    assertEquals(4, solution.maxProduct(intArrayOf(3, -1, 4)))

    assertEquals(1, solution.maxProduct(intArrayOf(-3, 0, 1, -2)))

    assertEquals(24, solution.maxProduct(intArrayOf(2, -5, -2, -4, 3)))
}