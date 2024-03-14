package medium

func numSubarraysWithSum(nums []int, goal int) int {
	frequency := make(map[int]int, len(nums))

	sum := 0
	result := 0
	for _, num := range nums {
		sum += num
		if sum == goal {
			result++
		}

		if v, ok := frequency[sum-goal]; ok {
			result += v
		}

		frequency[sum] = frequency[sum] + 1
	}

	return result
}

func slidingAtMost(nums []int, goal int) int {
	sum := 0

	left := 0
	right := 0

	result := 0
	for right < len(nums) {
		sum += nums[right]

		for left <= right && sum > goal {
			sum -= nums[left]
			left++
		}

		result += right - left + 1
		right++
	}

	return result
}

func numSubarraysWithSum2(nums []int, goal int) int {
	return slidingAtMost(nums, goal) - slidingAtMost(nums, goal-1)
}
