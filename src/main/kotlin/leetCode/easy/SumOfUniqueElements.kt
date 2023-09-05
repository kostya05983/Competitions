package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class SumOfUniqueElements {
    fun sumOfUnique(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        var result = 0
        for (num in nums) {
            val value = map[num]
            if (value != null && value == 1) {
                result -= num
                map[num] = value + 1
            } else if (value == null) {
                result += num
                map[num] = 1
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = SumOfUniqueElements()
    val example1 = solution.sumOfUnique(intArrayOf(1, 2, 3, 2))
    assertEquals(4, example1)

    val example2 = solution.sumOfUnique(intArrayOf(1, 1, 1, 1, 1))
    assertEquals(0, example2)

    val example3 = solution.sumOfUnique(intArrayOf(1, 2, 3, 4, 5))
    assertEquals(15, example3)
}