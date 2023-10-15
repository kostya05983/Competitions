package leetCode.hard

import java.math.BigInteger

class ConstructProductMatrix {
    fun constructProductMatrix(grid: Array<IntArray>): Array<IntArray> {
        var commonProduct = BigInteger("1")

        for (element in grid) {
            for (j in grid[0].indices) {
                commonProduct = commonProduct.multiply(BigInteger.valueOf(element[j].toLong()))
            }
        }

        val resultGrid = Array(grid.size) { IntArray(grid[0].size) }

        for (i in grid.indices) {
            for (j in grid[0].indices) {
                resultGrid[i][j] =
                    (commonProduct.divide(BigInteger.valueOf(grid[i][j].toLong()))).mod(BigInteger.valueOf(12345L))
                        .toInt()
            }
        }

        return resultGrid
    }
}

fun main() {
    val solution = ConstructProductMatrix()
    println(solution.constructProductMatrix(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))).map { it.toList() })
    println(
        solution.constructProductMatrix(arrayOf(intArrayOf(12345), intArrayOf(2), intArrayOf(1))).map { it.toList() })
    println(
        solution.constructProductMatrix(arrayOf(intArrayOf(123456), intArrayOf(2), intArrayOf(1))).map { it.toList() })
}