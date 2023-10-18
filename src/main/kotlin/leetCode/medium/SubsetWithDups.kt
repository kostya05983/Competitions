package leetCode.medium

class SubsetWithDups {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()

        subsets(0, mutableListOf(), nums, result)

        return result.toList()
    }

    private fun subsets(i: Int, current: MutableList<Int>, nums: IntArray, result: MutableList<List<Int>>) {
        result.add(current.toList())

        for (j in i until nums.size) {
            if (j == i || nums[j] != nums[j - 1]) {
                current.add(nums[j])

                subsets(j + 1, current, nums, result)

                current.removeAt(current.size - 1)
            }
        }
    }
}