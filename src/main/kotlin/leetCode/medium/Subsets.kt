package leetCode.medium

class Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        subsets(0, mutableListOf(), nums, result)

        return result
    }

    private fun subsets(i: Int, current: MutableList<Int>, nums: IntArray, result: MutableList<List<Int>>) {
        result.add(current.toList())

        for (j in i until nums.size) {
            current.add(nums[j])

            subsets(j + 1, current, nums, result)

            current.removeAt(current.size - 1)
        }
    }
}

fun main(args: Array<String>) {
    val solution = Subsets()
    println(solution.subsets(intArrayOf(1, 2, 3)))
    println(solution.subsets(intArrayOf(0)))
}