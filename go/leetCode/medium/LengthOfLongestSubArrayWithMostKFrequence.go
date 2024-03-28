package medium

func maxSubarrayLength(nums []int, k int) int {
	frequencies := make(map[int]int, 0)

	left := 0
	right := 0

	maxLength := 0

	for ; right < len(nums); right++ {
		num := nums[right]

		frequencies[num]++

		for frequencies[num] > k {
			frequencies[nums[left]]--
			left++
		}

		maxLength = max(maxLength, right-left+1)
	}

	return maxLength
}
