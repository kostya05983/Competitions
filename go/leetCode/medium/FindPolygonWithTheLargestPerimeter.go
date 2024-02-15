package medium

import (
	"sort"
)

func LargestPerimeter(nums []int) int64 {
	return largestPerimeter(nums)
}

func largestPerimeter(nums []int) int64 {
	sort.Ints(nums)

	prefixSum := make([]int64, len(nums))

	var sum int64 = 0

	for i := 0; i < len(nums); i++ {
		sum += int64(nums[i])
		prefixSum[i] = sum
	}

	var result int64 = -1
	for i := len(nums) - 1; i >= 2; i-- {
		num := int64(nums[i])

		if prefixSum[i-1] > num {
			result = max(result, num+prefixSum[i-1])
		}
	}

	return result
}
