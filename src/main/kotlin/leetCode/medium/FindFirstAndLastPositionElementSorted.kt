package leetCode.medium

import org.junit.jupiter.api.Assertions.assertArrayEquals

class FindFirstAndLastPositionElementSorted {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) return intArrayOf(-1, -1)

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

                    return intArrayOf(minLeft + 1, maxRight - 1)
                }

                target < num -> {
                    right = mid - 1
                }

                target > num -> {
                    left = mid + 1
                }
            }
        }

        return intArrayOf(-1, -1)
    }
}

fun main(args: Array<String>) {
    val solution = FindFirstAndLastPositionElementSorted()
    val example1 = solution.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8)
    assertArrayEquals(intArrayOf(3, 4), example1)

    val example2 = solution.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6)
    assertArrayEquals(intArrayOf(-1, -1), example2)

    val example3 = solution.searchRange(intArrayOf(), 0)
    assertArrayEquals(intArrayOf(-1, -1), example3)

    val example4 = solution.searchRange(intArrayOf(1, 3), 1)
    assertArrayEquals(intArrayOf(0, 0), example4)

    val example5 = solution.searchRange(intArrayOf(2, 2), 3)
    assertArrayEquals(intArrayOf(-1, -1), example5)
}