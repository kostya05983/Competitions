package leetCode.medium

import java.util.LinkedList

class Permutations {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
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
            if (!visited[i]) {
                current.add(nums[i])
                visited[i] = true
                generatePermutate(nums, current, visited, result)
                visited[i] = false
                current.pollLast()
            }
        }
    }
}

fun main(args: Array<String>) {
    val solution = Permutations()
    println(solution.permute(intArrayOf(1, 2, 3)))
}