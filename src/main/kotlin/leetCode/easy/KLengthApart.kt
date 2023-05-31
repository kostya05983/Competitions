package leetCode.easy

class KLengthApart {
    fun kLengthApart(nums: IntArray, k: Int): Boolean {
        var index = -1
        for (i in nums.indices) {
            if (nums[i] != 1) continue

            if (index!=-1 && i - index <= k)
                return false

            index = i
        }
        return true
    }
}

fun main(args: Array<String>) {
    val solution = KLengthApart()
    val example1 = solution.kLengthApart(intArrayOf(1, 0, 0, 0, 1, 0, 0, 1), 2)
    require(example1)

    val example2 = solution.kLengthApart(intArrayOf(1, 0, 0, 1, 0, 1), 2)
    require(!example2)
}