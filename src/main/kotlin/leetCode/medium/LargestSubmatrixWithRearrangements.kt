package leetCode.medium

class LargestSubmatrixWithRearrangements {
    fun largestSubmatrix(matrix: Array<IntArray>): Int {
        val n = matrix[0].size
        for (i in 0 until n) {
            for (j in matrix.indices) {
                if (matrix[j][i] == 1)
                    matrix[j][i] = matrix[j][i] + (matrix.getOrNull(j - 1)?.get(i) ?: 0)
            }
        }

        var result = 0
        for (row in matrix) {
            row.sortDescending()

            for (j in 0 until n) {
                result = maxOf(result, row[j] * (j + 1))
            }

        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = LargestSubmatrixWithRearrangements()
    println(solution.largestSubmatrix(arrayOf(intArrayOf(0, 0, 1), intArrayOf(1, 1, 1), intArrayOf(1, 0, 1))))
}