package leetCode.medium

class IncrementSubmatricesByOne {
    fun rangeAddQueries(n: Int, queries: Array<IntArray>): Array<IntArray> {
        val matrix = Array(n) { IntArray(n) }

        for (query in queries) {
            val (topLeftRow, topLeftColumn) = query
            val bottomRightRow = query[2] + 1
            val bottomRightColumn = query[3] + 1

            matrix[topLeftRow][topLeftColumn]++

            if (bottomRightColumn < n) {
                matrix[topLeftRow][bottomRightColumn]--
            }

            if (bottomRightRow < n) {
                matrix[bottomRightRow][topLeftColumn]--
            }

            if (bottomRightRow < n && bottomRightColumn < n) {
                matrix[bottomRightRow][bottomRightColumn]++
            }
        }

        for (i in 0 until n) {
            for (j in 1 until n) {
                matrix[i][j] += matrix[i][j - 1]
            }
        }

        for (i in 1 until n) {
            for (j in 0 until n) {
                matrix[i][j] += matrix[i - 1][j]
            }
        }

        return matrix
    }
}

fun main(args: Array<String>) {
    val solution = IncrementSubmatricesByOne()
    val example = arrayOf(intArrayOf(1, 1, 2, 2), intArrayOf(0, 0, 1, 1))
    solution.rangeAddQueries(3, example)
}