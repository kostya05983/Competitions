package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class IncreasingTripletSubsequence {
    fun increasingTriplet(nums: IntArray): Boolean {
        if (nums.size < 3) return false

        val minArray = IntArray(3) { Int.MAX_VALUE }
        for (num in nums) {
            if (num <= minArray[0]) {
                minArray[0] = num
            } else if (num <= minArray[1]) {
                minArray[1] = num
            } else {
                return true
            }
        }

        return false
    }
}

fun main(args: Array<String>) {
    val solution = IncreasingTripletSubsequence()
    assertEquals(true, solution.increasingTriplet(intArrayOf(1, 2, 3, 4, 5)))

    assertEquals(false, solution.increasingTriplet(intArrayOf(5, 4, 3, 2, 1)))

    assertEquals(true, solution.increasingTriplet(intArrayOf(2, 1, 5, 0, 4, 6)))

    assertEquals(true, solution.increasingTriplet(intArrayOf(20, 100, 10, 12, 5, 13)))

    assertEquals(true, solution.increasingTriplet(intArrayOf(1, 5, 0, 4, 1, 3)))
}