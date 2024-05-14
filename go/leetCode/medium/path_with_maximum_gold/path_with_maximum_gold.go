package path_with_maximum_gold

func getMaximumGold(grid [][]int) int {
	result := 0
	for i := range grid {
		for j := range grid[i] {
			if grid[i][j] != 0 {

				result = max(result, traverse(i, j, grid))
			}
		}
	}

	return result
}

func traverse(i, j int, grid [][]int) int {
	if i < 0 || j < 0 || i >= len(grid) || j >= len(grid[0]) {
		return 0
	}
	if grid[i][j] <= 0 {
		return 0
	}

	rowDiff := []int{0, 1, -1, 0}
	columnDiff := []int{-1, 0, 0, 1}

	grid[i][j] = -grid[i][j]
	result := 0
	for l := 0; l < 4; l++ {
		result = max(result, traverse(i+rowDiff[l], j+columnDiff[l], grid))
	}
	grid[i][j] = -grid[i][j]

	return result + grid[i][j]
}
