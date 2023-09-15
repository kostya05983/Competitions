package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class IntersectionMultipleArrays {
    fun intersection(nums: Array<IntArray>): List<Int> {
        val array = IntArray(1000 + 1)

        for (num in nums) {
            for (element in num) {
                array[element]++
            }
        }

        val result = mutableListOf<Int>()
        for (i in array.indices) {
            if (array[i] == nums.size) {
                result.add(i)
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = IntersectionMultipleArrays()

    val example1 =
        solution.intersection(arrayOf(intArrayOf(3, 1, 2, 4, 5), intArrayOf(1, 2, 3, 4), intArrayOf(3, 4, 5, 6)))
    assertEquals(listOf(3, 4), example1)
}