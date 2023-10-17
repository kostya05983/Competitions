package leetCode.easy

class Shift2dGrid {
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val result = Array(grid.size) { IntArray(grid[0].size) }
        for (i in grid.indices) {
            for (j in 0 until grid[0].size) {
                val index = getIndex(i, j, grid.size, grid[0].size, k)

                val indexI = index.first
                val indexJ = index.second

                result[indexI][indexJ] = grid[i][j]
            }
        }

        return result.map { it.toList() }
    }

    private fun getIndex(i: Int, j: Int, gridSize: Int, rowSize: Int, k: Int): Pair<Int, Int> {
        val remainJ = j + k

        val rowIndex = (i + (remainJ / rowSize)).rem(gridSize)
        return rowIndex to remainJ.rem(rowSize)
    }
}

fun main(args: Array<String>) {
    val solution = Shift2dGrid()
    println(
        solution.shiftGrid(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9)
            ), 1
        )
    )
    println(
        solution.shiftGrid(
            arrayOf(
                intArrayOf(3, 8, 1, 9), intArrayOf(19, 7, 2, 5), intArrayOf(4, 6, 11, 10),
                intArrayOf(12, 0, 21, 13)
            ), 4
        )
    )
    println(
        solution.shiftGrid(
            arrayOf(
                intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9),
            ), 9
        )
    )
}