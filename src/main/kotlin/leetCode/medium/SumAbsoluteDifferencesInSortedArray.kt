package leetCode.medium

class SumAbsoluteDifferencesInSortedArray {
    fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
        val n = nums.size
        val prefixSum = IntArray(n)

        for(i in 0 until n) {
            prefixSum[i] = prefixSum.getOrElse(i-1, {0})+ nums[i]
        }

        println(prefixSum.toList())

        val result = IntArray(n)

        for(i in 0 until n) {
            val prefix = prefixSum[i]-nums[i]
            val suffix = prefixSum[n-1]-prefixSum[i]

            result[i] = i*nums[i]-prefix + suffix-(n-1-i)*nums[i]
        }

        return result
    }
}