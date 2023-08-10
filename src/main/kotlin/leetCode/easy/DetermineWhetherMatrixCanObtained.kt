package leetCode.easy

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.math.abs

class DetermineWhetherMatrixCanObtained {
    fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
        val n = mat.size
        val degreesRotations = mutableListOf(
            ::getIndex0,
            ::getIndex90,
            ::getIndex180,
            ::getIndex270
        )

        for (i in mat.indices) {
            for (j in mat[0].indices) {
                var k = 0
                while (k < degreesRotations.size) {
                    val degreeRotation = degreesRotations[k]
                    val result = degreeRotation(i, j, n)
                    if (mat[result.first][result.second] != target[i][j]) {
                        degreesRotations.removeAt(k)
                        k--
                    }
                    k++
                }
                if (degreesRotations.isEmpty()) return false
            }
        }

        return true
    }

    private fun getIndex0(i: Int, j: Int, n: Int): Pair<Int, Int> {
        return i to j
    }

    private fun getIndex90(i: Int, j: Int, n: Int): Pair<Int, Int> {
        return j to n - 1 - i
    }

    private fun getIndex180(i: Int, j: Int, n: Int): Pair<Int, Int> {
        return n - 1 - i to n - 1 - j
    }

    private fun getIndex270(i: Int, j: Int, n: Int): Pair<Int, Int> {
        return n - 1 - j to i
    }
}

fun main(args: Array<String>) {
    val solution = DetermineWhetherMatrixCanObtained()
    val example1 = solution.findRotation(
        arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)),
        arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
    )
    assertEquals(true, example1)

    val example2 = solution.findRotation(
        arrayOf(intArrayOf(0, 1), intArrayOf(1, 1)),
        arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
    )
    assertEquals(false, example2)

    val example3 = solution.findRotation(
        arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(1, 1, 1)),
        arrayOf(intArrayOf(1, 1, 1), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0))
    )
    assertEquals(true, example3)
}