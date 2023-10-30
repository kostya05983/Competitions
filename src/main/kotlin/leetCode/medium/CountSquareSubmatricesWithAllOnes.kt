package leetCode.medium

import kotlin.math.min

class CountSquareSubmatricesWithAllOnes {
    fun countSquares(matrix: Array<IntArray>): Int {
        for (i in 1 until matrix.size) {
            for (j in 1 until matrix[0].size) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = minOf(matrix[i - 1][j - 1], min(matrix[i - 1][j], matrix[i][j - 1])) + 1
                }
            }
        }

        return matrix.sumOf { it.sum() }
    }
}

fun main(args: Array<String>) {
    val solution = CountSquareSubmatricesWithAllOnes()

    println(
        solution.countSquares(
            arrayOf(
                intArrayOf(0, 1, 1, 1),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(0, 1, 1, 1)
            )
        )
    )

    println(
        solution.countSquares(
            arrayOf(
                intArrayOf(1, 0, 1),
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 0)
            )
        )
    )
    println(
        solution.countSquares(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(1, 1, 1),
                intArrayOf(1, 1, 0)
            )
        )
    )
    println(
        solution.countSquares(
            arrayOf(
                intArrayOf(1, 1, 1),
                intArrayOf(1, 1, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(0, 0, 0),
            )
        )
    )
}