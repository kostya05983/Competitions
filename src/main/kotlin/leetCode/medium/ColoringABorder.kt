package leetCode.medium


class ColoringABorder {
    fun colorBorder(grid: Array<IntArray>, row: Int, col: Int, color: Int): Array<IntArray> {
        val pointColor = grid[row][col]

        if (pointColor == color) return grid

        val travelMatrix = Array(grid.size) { BooleanArray(grid[0].size) }

        colorBorder(grid, row, col, pointColor, color, travelMatrix)

        return grid
    }

    private fun colorBorder(
        grid: Array<IntArray>,
        row: Int,
        col: Int,
        pointColor: Int,
        color: Int,
        travelMatrix: Array<BooleanArray>
    ): Boolean {
        if (row < 0 || row > grid.lastIndex || col < 0 || col > grid[0].lastIndex) {
            return true
        }

        if (travelMatrix[row][col]) return false

        if (grid[row][col] != pointColor) {
            return true
        }
        travelMatrix[row][col] = true

        //верх есть и он такого же цвета
        val up = colorBorder(grid, row - 1, col, pointColor, color, travelMatrix)
        val right = colorBorder(grid, row, col + 1, pointColor, color, travelMatrix)
        val bottom = colorBorder(grid, row + 1, col, pointColor, color, travelMatrix)
        val left = colorBorder(grid, row, col - 1, pointColor, color, travelMatrix)

        if (up || right || bottom || left) {
            grid[row][col] = color
        }

        return false
    }
}

fun main(args: Array<String>) {
    val solution = ColoringABorder()

//    val example1 = solution.colorBorder(arrayOf(intArrayOf(1, 1), intArrayOf(1, 2)), 0, 0, 3)
//    println(example1.map { it.toList() })
//
//    val example2 = solution.colorBorder(arrayOf(intArrayOf(1, 2, 2), intArrayOf(2, 3, 2)), 0, 1, 3)
//    println(example2.map { it.toList() })
//////
//    val example3 = solution.colorBorder(arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1), intArrayOf(1, 1, 1)), 1, 1, 2)
//    println(example3.map { it.toList() })

    val example4 = solution.colorBorder(
        arrayOf(
            intArrayOf(1, 2, 1, 2, 1, 2),
            intArrayOf(2, 2, 2, 2, 1, 2),
            intArrayOf(1, 2, 2, 2, 1, 2)
        ),
        1,
        3,
        1
    )
    println(example4.map { it.toList() })
}