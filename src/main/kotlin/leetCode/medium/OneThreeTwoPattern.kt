package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class OneThreeTwoPattern {
    fun find132pattern(nums: IntArray): Boolean {
        if (nums.size < 3) return false

        var i = 0
        var leftMin = nums[i]
        var k = 1

        var middle: Int? = null
        while (k < nums.size) {
            if (leftMin < nums[k]) {
                middle = nums[k]
                break
            } else {
                leftMin = minOf(leftMin, nums[k])
                i = k
            }
            k++
        }
        //массив отсортирован по убыванию
        if (middle == null) return false

        var j: Int = k + 1
        while (j < nums.size) {
            if (middle!! > nums[j] && nums[j] > nums[i]) {
                break
            } else {
                if (nums[j] > middle) {
                    middle = maxOf(middle, nums[j])
                    k = j
                }
            }
            j++
        }

        return j < nums.size && nums[i] < nums[k] && nums[k] > nums[j] && nums[i] < nums[j]
    }
}

fun main(args: Array<String>) {
    val solution = OneThreeTwoPattern()
    val example1 = solution.find132pattern(intArrayOf(1, 2, 3, 4))
    assertEquals(false, example1)

    val example2 = solution.find132pattern(intArrayOf(3, 1, 4, 2))
    assertEquals(true, example2)

    val example3 = solution.find132pattern(intArrayOf(-1, 3, 2, 0))
    assertEquals(true, example3)

    val example4 = solution.find132pattern(intArrayOf(1, 0, 1, -4, -3))
    assertEquals(false, example4)

    val example5 = solution.find132pattern(intArrayOf(1,4,0,-1,-2,-3,-1,-2))
    assertEquals(true, example5)
}