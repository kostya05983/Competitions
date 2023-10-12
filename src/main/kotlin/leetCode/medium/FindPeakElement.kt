package leetCode.medium

class FindPeakElement {
    fun findPeakElement(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1

        while (left != right) {
            val m = (left + right) / 2
            val value = nums[m]
            val next = nums[m + 1]
            when {
                next > value -> {
                    left = m + 1
                }

                next < value -> {
                    right = m
                }
            }
        }
        return left
    }
}

fun main(args: Array<String>) {
    val solution = FindPeakElement()
    println(solution.findPeakElement(intArrayOf(1, 2, 3, 1)))
    println(solution.findPeakElement(intArrayOf(1, 2, 1, 3, 5, 6, 4)))
}