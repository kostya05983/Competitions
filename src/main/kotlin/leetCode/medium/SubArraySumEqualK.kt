package leetCode.medium

class SubArraySumEqualK {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val prefixSum = IntArray(nums.size)
        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            prefixSum[i] = sum
        }

        val prefixSumToCount = mutableMapOf<Int, Int>()
        var count = 0
        for (i in nums.indices) {
            if (prefixSum[i] == k) {
                count++
            }

            val found = prefixSumToCount[prefixSum[i] - k]
            if (found != null) {
                count += found
            }

            prefixSumToCount[prefixSum[i]] = prefixSumToCount.getOrDefault(prefixSum[i], 0) + 1
        }

        return count
    }
}

fun main(args: Array<String>) {
    val solution = SubArraySumEqualK()
    println(solution.subarraySum(intArrayOf(1, 1, 1), 2))
    println(solution.subarraySum(intArrayOf(1, 2, 3), 3))
    println(solution.subarraySum(intArrayOf(1), 0))
    println(solution.subarraySum(intArrayOf(1, -1, 0), 0))
}