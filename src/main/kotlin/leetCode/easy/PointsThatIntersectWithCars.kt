package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class PointsThatIntersectWithCars {

    fun numberOfPoints(nums: List<List<Int>>): Int {
        val sorted = nums.sortedBy { it[0] }
        var result = 0

        var end = -1
        for (sort in sorted) {
            if (sort[1] <= end) {
                continue
            }
            if (sort[0] == end) {
                result -= 1
            }
            if (end > sort[0] && sort[1] > end) {
                result -= (end - sort[0] + 1)
            }
            result += sort[1] - sort[0] + 1
            end = sort[1]
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = PointsThatIntersectWithCars()
    val example1 = solution.numberOfPoints(arrayListOf(listOf(3, 6), listOf(1, 5), listOf(4, 7)))
    assertEquals(7, example1)

    val example2 = solution.numberOfPoints(arrayListOf(listOf(1, 3), listOf(5, 8)))
    assertEquals(7, example2)

    val example3 = solution.numberOfPoints(arrayListOf(listOf(1, 9)))
    assertEquals(9, example3)

    val example4 = solution.numberOfPoints(arrayListOf(listOf(4, 4), listOf(3, 8), listOf(9, 10), listOf(9, 10)))
    assertEquals(8, example4)

    val example5 =
        solution.numberOfPoints(arrayListOf(listOf(2, 3), listOf(3, 9), listOf(5, 7), listOf(4, 10), listOf(9, 10)))
    assertEquals(example5, 9)
}