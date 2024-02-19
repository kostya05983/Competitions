package easy

import "math"

func countKDifference(nums []int, k int) int {
	n := len(nums)
	result := 0

	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if i < j && int(math.Abs(float64(nums[i]-nums[j]))) == k {
				result++
			}
		}
	}

	return result
}
