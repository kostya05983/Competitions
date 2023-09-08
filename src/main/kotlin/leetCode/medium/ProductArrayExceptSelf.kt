package leetCode.medium

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals

class ProductArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        var product = 1

        var zeroCount = 0
        for (num in nums) {
            if (num == 0) {
                zeroCount++
                continue
            }
            product *= num
        }

        val result = IntArray(nums.size)
        for (i in 0 until nums.size) {
            val num = nums[i]
            if (num == 0) {
                if (zeroCount == 1) {
                    result[i] = product
                } else {
                    result[i] = 0
                }
            } else {
                if (zeroCount > 0) {
                    result[i] = 0
                } else {
                    result[i] = product / nums[i]
                }
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = ProductArrayExceptSelf()
    val example1 = solution.productExceptSelf(intArrayOf(1, 2, 3, 4))
    assertArrayEquals(intArrayOf(24, 12, 8, 6), example1)

    val example2 = solution.productExceptSelf(intArrayOf(-1, 1, -0, -3, 3))
    assertArrayEquals(intArrayOf(0, 0, 9, 0, 0), example2)
}