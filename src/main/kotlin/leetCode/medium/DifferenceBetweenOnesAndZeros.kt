package leetCode.medium

class DifferenceBetweenOnesAndZeros {
    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
        val rows = Array(2) { IntArray(grid.size) }
        val columns = Array(2) { IntArray(grid[0].size) }

        for (i in grid.indices) {
            for (j in 0 until grid[i].size) {
                val num = grid[i][j]
                rows[num][i]++
                columns[num][j]++
            }
        }

        val result = Array(grid.size) { IntArray(grid[0].size) }
        for (i in grid.indices) {
            for (j in 0 until grid[i].size) {
                result[i][j] = rows[1][i] + columns[1][j] - rows[0][i] - columns[0][j]
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val solution = DifferenceBetweenOnesAndZeros()
    println(solution.onesMinusZeros(arrayOf(intArrayOf(0, 1, 1), intArrayOf(1, 0, 1), intArrayOf(0, 0, 1))).map { it.toList() })
}