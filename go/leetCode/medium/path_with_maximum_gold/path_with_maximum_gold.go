package path_with_maximum_gold

func getMaximumGold(grid [][]int) int {
	result := 0
	for i := range grid {
		for j := range grid[i] {
			if grid[i][j] != 0 {

				visited := make([][]bool, len(grid))
				for k := range grid {
					visited[k] = make([]bool, len(grid[0]))
				}
				result = max(result, traverse(i, j, grid, 0, visited))
			}
		}
	}

	return result
}

func traverse(i, j int, grid [][]int, sum int, visited [][]bool) int {
	if i < 0 || j < 0 || i >= len(grid) || j >= len(grid[0]) {
		return sum
	}
	if grid[i][j] == 0 {
		return sum
	}
	if visited[i][j] {
		return sum
	}



	rowDiff := []int{0, 1, -1, 0}
	columnDiff := []int{-1, 0, 0, 1}

	visited[i][j] = true
	result := 0
	for l := 0; l < 4; l++ {
		result = max(result, traverse(i+rowDiff[l], j+columnDiff[l], grid, sum+grid[i][j], visited))
	}
	visited[i][j] = false

	return result
}
