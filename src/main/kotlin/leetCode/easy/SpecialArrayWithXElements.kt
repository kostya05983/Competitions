package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class SpecialArrayWithXElements {
    fun specialArray(nums: IntArray): Int {
        nums.sortDescending()

        if (nums.size < nums.last()) return nums.size

        var currentX = 0
        for (i in nums.indices) {
            if (currentX < nums[i]) {
                currentX++
            } else {
                if (nums[i] == currentX) return -1
                return currentX
            }
        }

        if (currentX == nums.size) return nums.size

        return -1
    }
}

fun main(args: Array<String>) {
    val solution = SpecialArrayWithXElements()
    val example1 = solution.specialArray(intArrayOf(3, 5))
    assertEquals(2, example1)

    val example2 = solution.specialArray(intArrayOf(0, 0))
    assertEquals(-1, example2)

    val example3 = solution.specialArray(intArrayOf(0, 4, 3, 0, 4))
    assertEquals(3, example3)

    val example4 = solution.specialArray(intArrayOf(1, 0, 0, 6, 4, 9))
    assertEquals(3, example4)

    val example5 = solution.specialArray(intArrayOf(3, 6, 7, 7, 0))
    assertEquals(-1, example5)

    val example6 = solution.specialArray(intArrayOf(3))
    assertEquals(1, example6)

    val example7 = solution.specialArray(
        intArrayOf(
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100,
            100
        )
    )
    assertEquals(100, example7)
}