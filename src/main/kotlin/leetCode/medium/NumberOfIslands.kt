package leetCode.medium

class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }

        var count = 0
        for (i in grid.indices) {
            val row = grid[i]
            for (j in row.indices) {
                val num = row[j]
                if (num == '1' && !visited[i][j]) {
                    dfs(i, j, grid, visited)
                    count++
                }
            }
        }

        return count
    }

    private fun dfs(i: Int, j: Int, grid: Array<CharArray>, visited: Array<BooleanArray>) {
        val n = grid[0].size
        if (j >= n || j < 0) return
        if (i >= grid.size || i < 0) return

        val count = if (grid[i][j] == '1' && !visited[i][j]) {
            visited[i][j] = true
            1
        } else 0

        if (count == 0) return

        dfs(i - 1, j, grid, visited)
        dfs(i + 1, j, grid, visited)
        dfs(i, j + 1, grid, visited)
        dfs(i, j - 1, grid, visited)
    }
}