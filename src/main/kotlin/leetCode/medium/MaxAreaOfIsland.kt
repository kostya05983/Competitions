package leetCode.medium

class MaxAreaOfIsland {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }

        var maxIslandArea = 0
        for (i in grid.indices) {
            val row = grid[i]
            for (j in row.indices) {
                val num = row[j]
                if (num == 1 && !visited[i][j]) {
                    maxIslandArea = maxOf(dfs(i, j, grid, visited), maxIslandArea)
                }
            }
        }

        return maxIslandArea
    }

    private fun dfs(i: Int, j: Int, grid: Array<IntArray>, visited: Array<BooleanArray>): Int {
        val n = grid[0].size
        if (j >= n || j < 0) return 0
        if (i >= grid.size || i < 0) return 0

        val count = if (grid[i][j] == 1 && !visited[i][j]) {
            visited[i][j] = true
            1
        } else 0

        if (count == 0) return 0

        return count + dfs(i - 1, j, grid, visited) + dfs(i + 1, j, grid, visited) + dfs(i, j + 1, grid, visited) + dfs(
            i,
            j - 1,
            grid,
            visited
        )
    }
}

fun main(args: Array<String>) {
    val solution = MaxAreaOfIsland()
}