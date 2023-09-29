package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class MaximumCountPositiveAndNegative {
    fun maximumCount(nums: IntArray): Int {
        if (nums.first() > 0) return nums.size
        if (nums.last() < 0) return nums.size

        var left = 0
        var right = nums.size - 1
        var wasCompare: Boolean? = null
        var mid: Int = left + (right - left) / 2
        while (left <= right) {
            mid = left + (right - left) / 2
            val num = nums[mid]

            when {
                num == 0 -> {
                    break
                }

                num < 0 -> {
                    if (wasCompare != null && !wasCompare) break
                    wasCompare = true
                    left = mid + 1
                }

                num > 0 -> {
                    if (wasCompare != null && wasCompare) break
                    wasCompare = false
                    right = mid - 1
                }
            }
        }
        var leftMin = mid
        var rightMax = mid
        while (leftMin >= 0 && nums[leftMin] >= 0) {
            leftMin--
        }
        while (leftMin < nums.size && nums[leftMin + 1] < 0) {
            leftMin++
        }
        while (rightMax < nums.size && nums[rightMax] <= 0) {
            rightMax++
        }
        while (rightMax >= 0 && nums[rightMax - 1] > 0) {
            rightMax--
        }

        return maxOf(leftMin + 1, nums.size - rightMax)
    }
}

fun main(args: Array<String>) {
    val solution = MaximumCountPositiveAndNegative()
    val example1 = solution.maximumCount(intArrayOf(-2, -1, -1, 1, 2, 3))
    assertEquals(3, example1)

    val example2 = solution.maximumCount(intArrayOf(-3, -2, -1, 0, 0, 1, 2))
    assertEquals(3, example2)

    val example3 = solution.maximumCount(intArrayOf(5, 20, 66, 1314))
    assertEquals(4, example3)

    val example4 = solution.maximumCount(intArrayOf(-1563, -236, -114, -55, 427, 447, 687, 752, 1021, 1636))
    assertEquals(6, example4)

    val example5 = solution.maximumCount(intArrayOf(0, 0, 0, 0))
    assertEquals(0, example5)
}