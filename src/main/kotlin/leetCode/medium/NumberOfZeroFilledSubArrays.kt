package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class NumberOfZeroFilledSubArrays {
    fun zeroFilledSubarray(nums: IntArray): Long {
        var result = 0L
        var count = 1

        for (element in nums) {
            if (element == 0) {
                result += count
                count++
            } else {
                count = 1
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = NumberOfZeroFilledSubArrays()
    val example1 = solution.zeroFilledSubarray(intArrayOf(1, 3, 0, 0, 2, 0, 0, 4))
    assertEquals(6, example1)

    val example2 = solution.zeroFilledSubarray(intArrayOf(0, 0, 0, 2, 0, 0))
    assertEquals(9, example2)

    val example3 = solution.zeroFilledSubarray(intArrayOf(2, 10, 2019))
    assertEquals(0, example3)
}