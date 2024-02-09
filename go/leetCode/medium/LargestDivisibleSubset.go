package medium

import (
	"sort"
)

func largestDivisibleSubset(nums []int) []int {
	var n = len(nums)

	var eds [][]int

	for range nums {
		var list []int
		eds = append(eds, list)
	}

	sort.Ints(nums)

	for i := 0; i < n; i++ {
		var maxSubset []int

		for k := 0; k < i; k++ {
			if nums[i]%nums[k] == 0 && len(maxSubset) < len(eds[k]) {
				maxSubset = eds[k]
			}
		}

		eds[i] = append(eds[i], maxSubset...)
		eds[i] = append(eds[i], nums[i])
	}

	var ret []int
	for i := 0; i < n; i++ {
		if len(ret) < len(eds[i]) {
			ret = eds[i]
		}
	}

	return ret
}
