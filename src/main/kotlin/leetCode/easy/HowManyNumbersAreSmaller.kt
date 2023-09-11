package leetCode.easy

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals

class HowManyNumbersAreSmaller {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        for (i in 0 until nums.size) {
            var count = 0
            for (j in 0 until nums.size) {
                if (i != j && nums[j] < nums[i]) count++
            }
            result[i] = count
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = HowManyNumbersAreSmaller()
    val example1 = solution.smallerNumbersThanCurrent(intArrayOf(8, 1, 2, 2, 3))
    assertArrayEquals(intArrayOf(4, 0, 1, 1, 3), example1)

    val example2 = solution.smallerNumbersThanCurrent(intArrayOf(6, 5, 3, 8))
    assertArrayEquals(intArrayOf(2, 1, 0, 3), example2)

    val example3 = solution.smallerNumbersThanCurrent(intArrayOf(7, 7, 7, 7))
    assertArrayEquals(intArrayOf(0, 0, 0, 0), example3)
}