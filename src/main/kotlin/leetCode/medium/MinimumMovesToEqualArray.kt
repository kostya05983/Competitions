package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.math.abs

class MinimumMovesToEqualArray {
    fun minMoves2(nums: IntArray): Int {
        nums.sort()
        val medium = nums[nums.size / 2]

        var sumOperations = 0
        for (num in nums) {
            sumOperations += abs(medium - num)
        }

        return sumOperations
    }
}

fun main(args: Array<String>) {
    val solution = MinimumMovesToEqualArray()
    val example1 = solution.minMoves2(intArrayOf(1, 2, 3))
    assertEquals(2, example1)

    val example2 = solution.minMoves2(intArrayOf(1, 10, 2, 9))
    assertEquals(16, example2)
}