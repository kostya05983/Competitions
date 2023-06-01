package leetCode.medium

class KRadiusSubArrayAverages {
    fun getAverages(nums: IntArray, k: Int): IntArray {
        val windowOffset = k * 2
        val windowSize = windowOffset + 1
        val result = IntArray(nums.size) { -1 }
        var average = 0
        var averageRem = 0

        for (i in nums.indices) {
            val num = nums[i]
            val numDivided = num / windowSize
            average += numDivided
            averageRem += num - numDivided * windowSize

            if (i >= windowOffset) {
                result[i - k] = average + averageRem / windowSize
                val left = nums[i - windowOffset]
                val leftDivided = left / windowSize
                average -= leftDivided
                averageRem -= left - leftDivided * windowSize
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = KRadiusSubArrayAverages()
    val example1 = solution.getAverages(intArrayOf(7, 4, 3, 9, 1, 8, 5, 2, 6), 3)
    require(example1.contentEquals(intArrayOf(-1, -1, -1, 5, 4, 4, -1, -1, -1))) { "${example1.toList()}" }

    val example2 = solution.getAverages(intArrayOf(100000), 0)
    require(example2.contentEquals(intArrayOf(100000)))

    val example3 = solution.getAverages(intArrayOf(8), 100000)
    require(example3.contentEquals(intArrayOf(-1)))

    val example4 = solution.getAverages(intArrayOf(56725, 48784, 74934, 6772, 98570, 96847, 46483, 6592, 62552), 1)
    require(example4.contentEquals(intArrayOf(-1, 60147, 43496, 60092, 67396, 80633, 49974, 38542, -1)))
}