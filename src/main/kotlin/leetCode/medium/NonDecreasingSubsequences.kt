package leetCode.medium

import org.junit.jupiter.api.Assertions.assertEquals
import java.util.*

class NonDecreasingSubsequences {
    private fun recursion(list: LinkedList<Int>, index: Int, nums: IntArray, result: MutableList<List<Int>>) {
        if (list.size > 1) result.add(LinkedList<Int>(list))
        val used = mutableSetOf<Int>()

        for (i in index until nums.size) {
            if (used.contains(nums[i])) continue
            if (list.size == 0 || nums[i] >= list.peekLast()) {
                used.add(nums[i])
                list.add(nums[i])
                recursion(list, i + 1, nums, result)
                list.removeAt(list.size - 1)
            }
        }
    }

    fun findSubsequences(nums: IntArray): List<List<Int>> {
        val result = LinkedList<List<Int>>()

        recursion(LinkedList(), 0, nums, result)

        return result
    }
}

fun main(args: Array<String>) {
    val solution = NonDecreasingSubsequences()

    assertEquals(
        listOf(
            listOf(4, 6),
            listOf(4, 6, 7),
            listOf(4, 6, 7, 7),
            listOf(4, 7),
            listOf(4, 7, 7),
            listOf(6, 7),
            listOf(6, 7, 7),
            listOf(7, 7)
        ), solution.findSubsequences(intArrayOf(4, 6, 7, 7))
    )
}