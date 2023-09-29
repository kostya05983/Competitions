package leetCode.easy

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals

class FindTargetIndicesAfterSortingArray {
    fun targetIndices(nums: IntArray, target: Int): List<Int> {
        nums.sort()
        val result = mutableListOf<Int>()

        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            val num = nums[mid]

            when {
                num == target -> {
                    var minLeft = mid
                    var maxRight = mid
                    while (minLeft >= 0 && nums[minLeft] == target) {
                        minLeft--
                    }
                    while (maxRight < nums.size && nums[maxRight] == target) {
                        maxRight++
                    }

                    for (i in minLeft + 1..maxRight - 1) {
                        result.add(i)
                    }
                    return result
                }

                num < target -> {
                    left = mid + 1
                }

                num > target -> {
                    right = mid - 1
                }
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = FindTargetIndicesAfterSortingArray()
    val example1 = solution.targetIndices(intArrayOf(1, 2, 5, 2, 3), 2)
    assertEquals(listOf(1, 2), example1)

    val example2 = solution.targetIndices(intArrayOf(1, 2, 5, 2, 3), 3)
    assertEquals(listOf(3), example2)

    val example3 = solution.targetIndices(intArrayOf(1, 2, 5, 2, 3), 5)
    assertEquals(listOf(4), example3)
}