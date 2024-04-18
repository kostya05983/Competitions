package island_perimeter

func islandPerimeter(grid [][]int) int {
	count := 0

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == 1 {
				count += dfs(i, j, grid)
			}
		}
	}

	return count
}

func dfs(i int, j int, grid [][]int) int {
	if i < 0 || j < 0 || j >= len(grid[0]) || i >= len(grid) || grid[i][j] == 0 {
		return 1
	}

	if grid[i][j] == -1 {
		return 0
	}

	grid[i][j] = -1

	return dfs(i+1, j, grid) + dfs(i-1, j, grid) + dfs(i, j+1, grid) + dfs(i, j-1, grid)
}
