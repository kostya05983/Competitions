package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class LuckyNumbersInMatrix {
    fun luckyNumbers(matrix: Array<IntArray>): List<Int> {
        val minRows = IntArray(matrix.size)

        for (i in matrix.indices) {
            var min = Int.MAX_VALUE
            for (j in 0 until matrix[0].size) {
                min = minOf(matrix[i][j], min)
            }
            minRows[i] = min
        }

        val maxColumns = IntArray(matrix[0].size)
        for (i in 0 until matrix[0].size) {
            var max = Int.MIN_VALUE
            for (element in matrix) {
                max = maxOf(element[i], max)
            }
            maxColumns[i] = max
        }

        val result = mutableListOf<Int>()
        for (i in matrix.indices) {
            for (j in 0 until matrix[0].size) {
                val num = matrix[i][j]
                if (num == minRows[i] && num == maxColumns[j]) {
                    result.add(num)
                }
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = LuckyNumbersInMatrix()

    val example1 = solution.luckyNumbers(arrayOf(intArrayOf(3, 7, 8), intArrayOf(9, 11, 13), intArrayOf(15, 16, 17)))
    assertEquals(listOf(15), example1)
}