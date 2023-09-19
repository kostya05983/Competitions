package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals

class FindTheDuplicateNumber {
    fun findDuplicate(nums: IntArray): Int {
        var slow = 0
        var fast = 0
        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while (slow != fast)

        slow = 0

        while (slow != fast) {
            slow = nums[slow]
            fast = nums[fast]
        }

        return slow
    }

    fun findDuplicateNaive(nums: IntArray): Int {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] == nums[j]) return nums[i]
            }
        }

        return -1
    }
}

fun main(args: Array<String>) {
    val solution = FindTheDuplicateNumber()
    assertEquals(2, solution.findDuplicate(intArrayOf(1, 3, 4, 2, 2)))
}