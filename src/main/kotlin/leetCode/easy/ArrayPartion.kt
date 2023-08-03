package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class ArrayPartion {
    fun arrayPairSum(nums: IntArray): Int {
        nums.sort()

        var sum = 0
        var i = 0
        while (i <= nums.lastIndex) {
            sum += nums[i]
            i += 2
        }

        return sum
    }
}

fun main(args: Array<String>) {
    val solution = ArrayPartion()
    val example1 = solution.arrayPairSum(intArrayOf(1, 4, 3, 2))
    assertEquals(4, example1)

    val example2 = solution.arrayPairSum(intArrayOf(6, 2, 6, 5, 1, 2))
    assertEquals(9, example2)
}