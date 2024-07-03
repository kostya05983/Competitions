package minimum_difference_largest_smallest_values

import (
	"math"
	"sort"
)

func minDifference(nums []int) int {
	sort.Ints(nums)

	if len(nums)<=4 {
		return 0
	}

	left := 0
	right := len(nums) - 4
	result := math.MaxInt
	for left < 4 {
		result = min(result, nums[right]-nums[left])
		left++
		right++
	}

	return result
}
