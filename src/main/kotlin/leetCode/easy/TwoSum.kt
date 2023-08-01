package leetCode.easy

import org.junit.jupiter.api.Assertions.assertArrayEquals

class TwoSum {


    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        for (i in 0 until nums.size) {
            val num = nums[i]
            val diff = target - num

            val found = map[diff]
            if (found != null) {
                return intArrayOf(found, i)
            }
            map[num] = i
        }

        throw IllegalArgumentException("No solution")
    }
}

fun main(args: Array<String>) {
    val solution = TwoSum()
    val example1 = solution.twoSum(intArrayOf(2, 7, 11, 15), 9)
    assertArrayEquals(intArrayOf(0, 1), example1)

    val example2 = solution.twoSum(intArrayOf(3, 2, 4), 6)
    assertArrayEquals(intArrayOf(1, 2), example2)

    val example3 = solution.twoSum(intArrayOf(3, 3), 6)
    assertArrayEquals(intArrayOf(0, 1), example3)
}