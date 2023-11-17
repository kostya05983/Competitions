package leetCode.medium

class MinimizeMaximumPairSumArray {
    fun minPairSum(nums: IntArray): Int {
        nums.sort()

        var left = 0
        var right = nums.size - 1

        var max = Int.MIN_VALUE
        while (left < right) {
            max = maxOf(nums[left] + nums[right], max)
            right--
            left++
        }

        return max
    }
}

fun main(args: Array<String>) {
    val solution = MinimizeMaximumPairSumArray()
    println(solution.minPairSum(intArrayOf(3, 5, 2, 3)))
    println(solution.minPairSum(intArrayOf(3, 5, 4, 2, 4, 6)))
    println(solution.minPairSum(intArrayOf(4, 1, 5, 1, 2, 5, 1, 5, 5, 4)))
}