package minimum_increment_make_array_unique

import "sort"

func minIncrementForUnique(nums []int) int {
	sort.Ints(nums)

	result := 0
	for i := 1; i < len(nums); i++ {
		if nums[i-1] == nums[i] || nums[i-1] > nums[i] {
			result += nums[i-1] - nums[i]
			result++
			nums[i] = nums[i-1] + 1
		}
	}

	return result
}
