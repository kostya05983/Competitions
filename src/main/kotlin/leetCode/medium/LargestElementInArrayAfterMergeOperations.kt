package leetCode.medium

class LargestElementInArrayAfterMergeOperations {
    fun maxArrayValue(nums: IntArray): Long {
        var sum = 0L
        for (i in nums.size - 1 downTo 0) {
            if (nums[i] > sum) sum = 0

            sum += nums[i]
        }

        return sum
    }
}