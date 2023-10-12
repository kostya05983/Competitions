package leetCode.easy

class CountHillsAndValleysInArray {
    fun countHillValley(nums: IntArray): Int {
        var count = 0

        var i = 0
        while (i < nums.size) {
            val num = nums[i]

            var left = nums[i]
            var leftIndex = i
            while (left == num && leftIndex >= 0) {
                left = nums[leftIndex]
                leftIndex--

            }

            var right = nums[i]
            var rightIndex = i
            while (right == num && rightIndex < nums.size) {
                right = nums[rightIndex]
                rightIndex++
            }

            if (num > left && num > right || num < left && num < right) {
                count++
            }
            if (i != (rightIndex - 1)) i = rightIndex - 1 else i++
        }

        return count
    }
}

fun main(args: Array<String>) {
    val solution = CountHillsAndValleysInArray()
    println(solution.countHillValley(intArrayOf(2, 4, 1, 1, 6, 5)))
}