package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class MostFrequentNumberFollowingKey {
    fun mostFrequent(nums: IntArray, key: Int): Int {
        val mostFrequentMap = mutableMapOf<Int, Int>()

        for (i in 0 until nums.size - 1) {
            if (key == nums[i]) {
                mostFrequentMap[nums[i + 1]] = mostFrequentMap.getOrDefault(nums[i + 1], 0) + 1
            }
        }

        return mostFrequentMap.maxBy { it.value }!!.key
    }
}

fun main(args: Array<String>) {
    val solution = MostFrequentNumberFollowingKey()
    val example1 = solution.mostFrequent(intArrayOf(1, 100, 200, 1, 100), 1)
    assertEquals(100, example1)

    val example2 = solution.mostFrequent(intArrayOf(2, 2, 2, 2, 3), 2)
    assertEquals(2, example2)
}

