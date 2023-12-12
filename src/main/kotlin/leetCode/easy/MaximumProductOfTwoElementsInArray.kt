package leetCode.easy

class MaximumProductOfTwoElementsInArray {
    fun maxProduct(nums: IntArray): Int {
        var max = Int.MIN_VALUE

        for (i in nums.indices) {
            for (j in nums.indices) {
                if (i != j) {
                    val result = (nums[i] - 1) * (nums[j] - 1)
                    max = maxOf(result, max)
                }
            }
        }

        return max
    }
}