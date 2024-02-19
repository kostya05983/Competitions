package easy

func countPairs(nums []int, k int) int {
	n := len(nums)
	result := 0

	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if i < j && nums[i] == nums[j] && i*j%k == 0 {
				result++
			}
		}
	}

	return result
}
