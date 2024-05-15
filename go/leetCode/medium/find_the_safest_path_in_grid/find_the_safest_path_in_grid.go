package find_the_safest_path_in_grid

import (
	"fmt"
	"math"
)

func maximumSafenessFactor(grid [][]int) int {
	thiefs := make([][]int, 0)

	for i := range grid {
		for j := range grid[i] {
			if grid[i][j] == 1 {
				thiefs = append(thiefs, []int{i, j})
			}
		}
	}

	for i := range grid {
		for j := range grid[i] {
			if grid[i][j] == 1 {
				grid[i][j] = -1
				continue
			}

			minManhatan := math.MaxInt
			for l := range thiefs {
				manhatan := math.Abs(float64(i)-float64(thiefs[l][0])) + math.Abs(float64(j)-float64(thiefs[l][1]))
				minManhatan = min(minManhatan, int(manhatan))
			}

			grid[i][j] = minManhatan
		}
	}

	fmt.Println(grid)

	maxSafenessPark := findPath(0, 0, grid, math.MaxInt)

	if maxSafenessPark == math.MinInt || maxSafenessPark == math.MaxInt {
		return 0
	}
	return maxSafenessPark
}

func findPath(i, j int, grid [][]int, minOnPath int) int {
	if i >= len(grid) || j >= len(grid[0]) || grid[i][j] == -1 {
		return math.MinInt
	}
	if i == len(grid)-1 && j == len(grid[0])-1 {
		return min(minOnPath, grid[i][j])
	}

	return max(findPath(i+1, j, grid, min(minOnPath, grid[i][j])), findPath(i, j+1, grid, min(minOnPath, grid[i][j])))
}
