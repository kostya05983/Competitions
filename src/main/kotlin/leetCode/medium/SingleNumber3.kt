package leetCode.medium

import org.junit.jupiter.api.Assertions.assertArrayEquals

class SingleNumber3 {
    fun singleNumber(nums: IntArray): IntArray {
        var xorResult = nums[0]
        for (i in 1 until nums.size) {
            xorResult = xorResult.xor(nums[i])
        }

        val diff = xorResult.and(-xorResult)

        val result = IntArray(2)

        for (num in nums) {
            if (num.and(diff) == 0) {
                result[0] = result[0].xor(num)
            } else {
                result[1] = result[1].xor(num)
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = SingleNumber3()
    val example1 = solution.singleNumber(intArrayOf(1, 2, 1, 3, 2, 5))
    assertArrayEquals(intArrayOf(5, 3), example1)

    val example2 = solution.singleNumber(intArrayOf(-1, 0))
    assertArrayEquals(intArrayOf(0, -1), example2)

    val example3 = solution.singleNumber(intArrayOf(0, 1))
    assertArrayEquals(intArrayOf(0, 1), example3)
}