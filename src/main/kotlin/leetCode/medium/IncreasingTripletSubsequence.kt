package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class IncreasingTripletSubsequence {
    fun increasingTriplet(nums: IntArray): Boolean {
        if (nums.size < 3) return false



        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] < nums[j]) {
                    for (k in j + 1 until nums.size) {
                        if (nums[i] < nums[j] && nums[j] < nums[k]) return true
                    }
                }
            }
        }

        return false
    }
}

//20,100,10,12,5,13
//-80,90,-2,7,-8,13

fun main(args: Array<String>) {
    val solution = IncreasingTripletSubsequence()
    assertEquals(true, solution.increasingTriplet(intArrayOf(1, 2, 3, 4, 5)))

    assertEquals(false, solution.increasingTriplet(intArrayOf(5, 4, 3, 2, 1)))

    assertEquals(true, solution.increasingTriplet(intArrayOf(2, 1, 5, 0, 4, 6)))

    assertEquals(true, solution.increasingTriplet(intArrayOf(20, 100, 10, 12, 5, 13)))

    assertEquals(true, solution.increasingTriplet(intArrayOf(1, 5, 0, 4, 1, 3)))
}