package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class MaximumAverageSubArray {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var average = Double.NEGATIVE_INFINITY

        var i = 0
        var sum = 0.0
        while (i < nums.size) {
            sum += nums[i]

            if (i >= k - 1) {
                average = maxOf(average, sum / k)
                sum -= nums[i - k + 1]
            }

            i++
        }

        return average
    }
}

fun main(args: Array<String>) {
    val solution = MaximumAverageSubArray()
    val example1 = solution.findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4)
    assertEquals(12.75000, example1)

    val example2 = solution.findMaxAverage(intArrayOf(5), 1)
    assertEquals(5.000, example2)

    val example3 = solution.findMaxAverage(intArrayOf(-1), 1)
    assertEquals(-1.00, example3)
}