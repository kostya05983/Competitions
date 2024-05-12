package largest_local_values_in_matrix

func largestLocal(grid [][]int) [][]int {
	result := make([][]int, len(grid)-2)
	for i := range result {
		result[i] = make([]int, len(grid)-2)
	}

	for i := range result {
		for j := range result[i] {
			result[i][j] = maxInGrid(grid, i+1, j+1)
		}
	}

	return result
}

func maxInGrid(grid [][]int, i int, j int) int {
	iIncrement := []int{-1, -1, -1, 0, 0, 0, 1, 1, 1}
	jIncrement := []int{-1, 0, 1, -1, 0, 1, -1, 0, 1}

	result := 0
	for l := range iIncrement {
		result = max(result, grid[i+iIncrement[l]][j+jIncrement[l]])
	}

	return result
}
