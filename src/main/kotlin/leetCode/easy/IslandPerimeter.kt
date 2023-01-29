package leetCode.easy

class IslandPerimeter {

    fun islandPerimeter(grid: Array<IntArray>): Int {
        var count = 0
        for (i in grid.indices) {
            for (j in 0 until grid[0].size) {
                if (grid[i][j] == 1) {
                    count += deepFirstSearch(i, j, grid)
                }
            }
        }

        return count
    }

    private fun deepFirstSearch(i: Int, j: Int, grid: Array<IntArray>): Int {
        if (i < 0 || j < 0 || j >= grid[0].size || i >= grid.size || grid[i][j] == 0) {
            return 1
        }
        if (grid[i][j] == -1) {
            return 0
        }

        grid[i][j] = -1

        return deepFirstSearch(i + 1, j, grid) + deepFirstSearch(i - 1, j, grid) + deepFirstSearch(
            i,
            j + 1,
            grid
        ) + deepFirstSearch(i, j - 1, grid)
    }
}

fun main(args: Array<String>) {
    println(
        IslandPerimeter().islandPerimeter(
            arrayOf(
                intArrayOf(0, 1, 0, 0),
                intArrayOf(1, 1, 1, 0),
                intArrayOf(0, 1, 0, 0),
                intArrayOf(1, 1, 0, 0)
            )
        )
    )

    println(
        IslandPerimeter().islandPerimeter(
            arrayOf(
                intArrayOf(1)
            )
        )
    )

    println(
        IslandPerimeter().islandPerimeter(
            arrayOf(
                intArrayOf(1, 0)
            )
        )
    )
}