package leetCode.easy

class FindMaximumDivisibilityScore {
    fun maxDivScore(nums: IntArray, divisors: IntArray): Int {
        var maxDivisor = Int.MAX_VALUE
        var maxScore = 0

        for (divisor in divisors) {
            var count = 0
            for (num in nums) {
                if (num.rem(divisor) == 0) {
                    count++
                }
            }
            if (maxScore == count) {
                if (divisor < maxDivisor) {
                    maxDivisor = divisor
                }
            }
            if (maxScore < count) {
                maxScore = count
                maxDivisor = divisor
            }
        }

        return maxDivisor
    }
}