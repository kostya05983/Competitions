package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class NRepeatedElementInSize2NArray {
    fun repeatedNTimes(nums: IntArray): Int {
        val frequencyMap = mutableMapOf<Int, Int>()
        val n = nums.size / 2

        for (num in nums) {
            val value = frequencyMap.getOrDefault(num, 0) + 1
            if (value == n) return num
            frequencyMap[num] = value
        }

        return -1
    }
}

fun main(args: Array<String>) {
    val solution = NRepeatedElementInSize2NArray()
    val example1 = solution.repeatedNTimes(intArrayOf(1, 2, 3, 3))
    assertEquals(3, example1)

    val example2 = solution.repeatedNTimes(intArrayOf(2, 1, 2, 5, 3, 2))
    assertEquals(2, example2)

    val example3 = solution.repeatedNTimes(intArrayOf(5, 1, 5, 2, 5, 3, 5, 4))
    assertEquals(5, example3)
}