package leetCode.easy

class MaximumProductDifferenceBetweenTwoPairs {
    fun maxProductDifference(nums: IntArray): Int {
        nums.sort()

        return (nums.last() * nums[nums.lastIndex - 1] - nums[0] * nums[1])
    }
}