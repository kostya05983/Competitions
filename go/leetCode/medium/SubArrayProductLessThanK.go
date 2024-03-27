package medium

func numSubarrayProductLessThanK(nums []int, k int) int {
	if k <= 1 {
		return 0
	}

	result := 0

	left := 0
	right := 0

	product := 1

	for ; right < len(nums); right++ {
		product *= nums[right]

		for product >= k {
			product /= nums[left]
			left++
		}

		result += right - left + 1
	}

	return result
}
