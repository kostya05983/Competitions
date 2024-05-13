package score_after_flipping_matrix

func matrixScore(grid [][]int) int {
	for i := range grid {
		if grid[i][0] != 0 {
			continue
		}
		for j := range grid[i] {
			if grid[i][j] == 0 {
				grid[i][j] = 1
			} else {
				grid[i][j] = 0
			}
		}
	}

	for j := range grid[0] {
		countZeros := 0
		for i := range grid {
			if grid[i][j] == 0 {
				countZeros++
			}
		}

		if countZeros > len(grid)-countZeros {
			for i := range grid {
				if grid[i][j] == 0 {
					grid[i][j] = 1
				} else {
					grid[i][j] = 0
				}
			}
		}
	}

	result := 0
	for i := range grid {
		rowNumber := 0
		degree := 0

		for j := len(grid[i])-1; j >= 0; j-- {
			rowNumber += grid[i][j] * pow2(degree)
			degree++
		}
		result += rowNumber
	}

	return result
}

func pow2(degree int) int {
	result := 1
	for degree > 0 {
		result *= 2
		degree--
	}

	return result
}
