package easy

import (
	"sort"
)

func minimumAbsDifference(arr []int) [][]int {
	sort.Ints(arr)

	n := len(arr)
	frequencies := make(map[int][][]int)
	minDiff := arr[1] - arr[0]

	for i := 0; i < n-1; i++ {
		diff := arr[i+1] - arr[i]
		frequencies[diff] = append(frequencies[diff], []int{arr[i], arr[i+1]})
		minDiff = min(diff, minDiff)
	}

	return frequencies[minDiff]
}