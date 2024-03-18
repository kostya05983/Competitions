package medium

import "sort"

func findMinArrowShots(points [][]int) int {
	if len(points) == 0 {
		return 0
	}

	sort.Slice(points, func(i, j int) bool {
		if points[i][0] == points[j][0] {
			return points[i][1] < points[j][1]
		}
		return points[i][0] < points[j][0]
	})

	right := points[0][1]
	count := 1

	for i := 1; i < len(points); i++ {
		if points[i][0] > right {
			right = points[i][1]
			count++
		}
	}

	return count
}
