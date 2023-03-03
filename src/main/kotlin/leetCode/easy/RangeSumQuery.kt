package leetCode.easy

class RangeSumQuery(nums: IntArray) {
    private var prefixSum: IntArray = IntArray(nums.size)

    init {
        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            prefixSum[i] = sum
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        val start = if (left > 0) prefixSum[left - 1] else 0
        return prefixSum[right] - start
    }
}

fun main(args: Array<String>) {
    val solution = RangeSumQuery(intArrayOf(-2, 0, 3, -5, 2, -1))
    val test1 = solution.sumRange(0, 2)
    require(test1 == 1)

    val test2 = solution.sumRange(2, 5)
    require(test2 == -1)

    val test3 = solution.sumRange(0, 5)
    require(test3 == -3)
}