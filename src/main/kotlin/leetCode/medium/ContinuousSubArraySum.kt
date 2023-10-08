package leetCode.medium

class ContinuousSubArraySum {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val prefixSum = IntArray(nums.size)

        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            prefixSum[i] = sum
        }

        var memory = mutableMapOf<Int, Int>()

//        for (i in 0 until nums.size) {
//
//            if (memory[])
//        }

        return false
    }
}