package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class LuckyNumbersInMatrix {
    fun luckyNumbers(matrix: Array<IntArray>): List<Int> {
        val minRows = IntArray(matrix.size) { Int.MAX_VALUE }
        val maxColumns = IntArray(matrix[0].size)

        for (i in matrix.indices) {
            for (j in 0 until matrix[0].size) {
                minRows[i] = minOf(matrix[i][j], minRows[i])
                maxColumns[j] = maxOf(matrix[i][j], maxColumns[j])
            }
        }

        val result = mutableListOf<Int>()
        for (i in matrix.indices) {
            for (j in 0 until matrix[0].size) {
                if (minRows[i] == maxColumns[j]) {
                    result.add(minRows[i])
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