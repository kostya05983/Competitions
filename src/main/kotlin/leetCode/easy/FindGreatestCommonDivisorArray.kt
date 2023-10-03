package leetCode.easy

class FindGreatestCommonDivisorArray {
    fun findGCD(nums: IntArray): Int {
        var min = nums[0]
        var max = nums[0]

        for (num in nums) {
            min = minOf(min, num)
            max = maxOf(max, num)
        }

        while (min != 0) {
            val tmp = max % min
            max = min
            min = tmp
        }

        return max
    }
}