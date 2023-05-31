package leetCode.easy

class KLengthApart {
    fun kLengthApart(nums: IntArray, k: Int): Boolean {
        var index = nums.indexOfFirst { it == 1 }

        for (i in index + 1 until nums.size) {
            if (nums[i] != 1) continue

            if (i - index <= k)
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