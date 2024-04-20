package find_all_groups_of_farmland

import "math"

func findFarmland(land [][]int) [][]int {
	m := len(land)
	n := len(land[0])

	visited := make([][]bool, m)
	for i := 0; i < m; i++ {
		visited[i] = make([]bool, n)
	}

	result := make([][]int, 0)

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if !visited[i][j] && land[i][j] == 1 {
				temp := []int{math.MaxInt, math.MaxInt, math.MinInt, math.MinInt}
				search(i, j, land, visited, temp)
				result = append(result, temp)
			}
		}
	}

	return result
}

func search(i, j int, land [][]int, visited [][]bool, result []int) {
	if i >= len(land) || j >= len(land[0]) || i < 0 || j < 0 || land[i][j] == 0 {
		return
	}
	if visited[i][j] {
		return
	}

	if i < result[0] || j < result[1] {
		result[0] = i
		result[1] = j
	}

	if i > result[2] || j > result[3] {
		result[2] = i
		result[3] = j
	}

	visited[i][j] = true

	search(i-1, j, land, visited, result)
	search(i+1, j, land, visited, result)
	search(i, j-1, land, visited, result)
	search(i, j+1, land, visited, result)
}
