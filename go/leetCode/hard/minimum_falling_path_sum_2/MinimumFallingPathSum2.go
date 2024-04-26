package minimum_falling_path_sum_2

import "math"

func minFallingPathSum(grid [][]int) int {
	dp := make([][]int, len(grid))

	for i := range dp {
		dp[i] = make([]int, len(grid[0]))
	}

	for i := range dp[0] {
		dp[len(dp)-1][i] = grid[len(dp)-1][i]
	}

	for row := len(grid) - 2; row >= 0; row-- {
		for col := 0; col < len(grid); col++ {
			nextMinimum := math.MaxInt
			for nextRowCol := 0; nextRowCol < len(grid); nextRowCol++ {
				if nextRowCol != col {
					nextMinimum = min(nextMinimum, dp[row+1][nextRowCol])
				}
			}

			dp[row][col] = grid[row][col] + nextMinimum
		}
	}

	result := math.MaxInt
	for col := 0; col < len(grid); col++ {
		result = min(result, dp[0][col])
	}

	return result
}
