package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals

class CellsWithOddValuesInMatrix {
    fun oddCells(m: Int, n: Int, indices: Array<IntArray>): Int {
        val matrix = Array(m) { IntArray(n) }
        var counter = 0

        for ((row, column) in indices) {
            for (i in 0 until n) {
                val newValue = matrix[row][i]++
                if (newValue.rem(2) == 0) {
                    counter++
                } else {
                    counter--
                }
            }
            for (i in 0 until m) {
                val newValue = matrix[i][column]++
                if (newValue.rem(2) == 0) {
                    counter++
                } else {
                    counter--
                }
            }
        }

        return counter
    }
}

fun main(args: Array<String>) {
    val solution = CellsWithOddValuesInMatrix()
    val example1 = solution.oddCells(2, 3, arrayOf(intArrayOf(0, 1), intArrayOf(1, 1)))
    assertEquals(6, example1)

    val example2 = solution.oddCells(2, 2, arrayOf(intArrayOf(1, 1), intArrayOf(0, 0)))
    assertEquals(0, example2)
}