package leetCode.medium

class Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        subsets(0, listOf(), nums, result)

        return result
    }

    private fun subsets(i: Int, current: List<Int>, nums: IntArray, result: MutableList<List<Int>>) {
        result.add(current)

        for (j in i until nums.size) {
            subsets(j + 1, current + nums[j], nums, result)
        }
    }
}

fun main(args: Array<String>) {
    val solution = Subsets()
    println(solution.subsets(intArrayOf(1, 2, 3)))
    println(solution.subsets(intArrayOf(0)))
}