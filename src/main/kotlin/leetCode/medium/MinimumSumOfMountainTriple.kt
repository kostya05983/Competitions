package leetCode.medium

class MinimumSumOfMountainTriple {
    fun minimumSum(nums: IntArray): Int {
        val left = IntArray(nums.size)
        val right = IntArray(nums.size)

        left[0] = nums[0]
        right[nums.size - 1] = nums[nums.size - 1]

        for (i in 1 until nums.size) {
            left[i] = minOf(left[i - 1], nums[i])
        }
        for (i in nums.size - 2 downTo 0) {
            right[i] = minOf(right[i + 1], nums[i])
        }

        var minSum = Int.MAX_VALUE
        for (i in 1 until nums.size - 1) {
            if (left[i] < nums[i] && right[i] < nums[i]) {
                minSum = minOf(minSum, left[i] + nums[i] + right[i])
            }
        }

        return if (minSum == Int.MAX_VALUE) -1 else minSum
    }
}