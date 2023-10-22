package leetCode.hard

class MaximumScoreGoodSubArray {
    fun maximumScore(nums: IntArray, k: Int): Int {
        var left = k
        var right = k
        var result = nums[k]
        var min = nums[k]

        while (left > 0 || right < nums.size - 1) {
            val leftNum = nums.getOrElse(left - 1) { 0 }
            val rightNum = nums.getOrElse(right + 1) { 0 }

            min = if (leftNum < rightNum) {
                right++
                minOf(min, nums[right])
            } else {
                left--
                minOf(min, nums[left])
            }

            result = maxOf(result, min * (right - left + 1))
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = MaximumScoreGoodSubArray()
    println(solution.maximumScore(intArrayOf(1, 4, 3, 7, 4, 5), 3))
    println(solution.maximumScore(intArrayOf(5, 5, 4, 5, 4, 1, 1, 1), 0))
}