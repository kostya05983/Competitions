package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.math.abs

class TheNumberBeautifulSubsets {
    fun beautifulSubsets(nums: IntArray, k: Int): Int {
        var result = 0
        for (i in 0 until nums.lastIndex) {
            for (j in i + 1 until nums.size) {
                val left = nums[i]
                val right = nums[j]
                if (abs(left - right) != k) {
                    result += 1.shl(nums.size - i - 2)
                }
            }
        }

        return 1.shl(nums.size) - result - 1
    }
}

fun main(args: Array<String>) {
    val solution = TheNumberBeautifulSubsets()
    val example = solution.beautifulSubsets(intArrayOf(2, 4, 6), 2)
    assertEquals(4, example)

    val example2 = solution.beautifulSubsets(intArrayOf(1), 1)
    assertEquals(1, example2)

    val example3 = solution.beautifulSubsets(intArrayOf(4, 2, 5, 9, 10, 3), 1)
    assertEquals(23, example3)
}