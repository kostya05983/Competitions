package leetCode.medium

import java.util.*
import kotlin.collections.ArrayList

class Permutations2 {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()
        generatePermutate(nums, LinkedList(), BooleanArray(nums.size), result)

        return result
    }

    private fun generatePermutate(
        nums: IntArray,
        current: LinkedList<Int>,
        visited: BooleanArray,
        result: MutableList<List<Int>>
    ) {
        if (current.size == nums.size) {
            result.add(ArrayList(current))
            return
        }

        for (i in nums.indices) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue
            current.add(nums[i])
            visited[i] = true
            generatePermutate(nums, current, visited, result)
            visited[i] = false
            current.pollLast()
        }
    }
}