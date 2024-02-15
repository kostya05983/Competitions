package easy

import "sort"

func largestPerimeter(nums []int) int {
	sort.Ints(nums)

	for i := len(nums) - 1; i >= 2; i-- {
		max := nums[i]
		secondMax := nums[i-1]
		thirdMax := nums[i-2]

		if secondMax+thirdMax > max {
			return max + secondMax + thirdMax
		}
	}

	return 0
}
