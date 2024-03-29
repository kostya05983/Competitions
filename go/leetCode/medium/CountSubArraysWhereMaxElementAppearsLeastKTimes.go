package medium

import "slices"

func countSubarrays(nums []int, k int) int64 {
	var result int64 = 0

	maxNum := slices.Max(nums)

	left := 0
	var right int64 = 0
	count := 0

	n := int64(len(nums))

	for ; right < n; right++ {
		num := nums[right]

		if num == maxNum {
			count++
		}

		for count == k {
			result += n - right
			leftNum := nums[left]
			if leftNum == maxNum {
				count--
			}
			left++
		}
	}

	return result
}
