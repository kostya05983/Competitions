package medium

func rearrangeArray(nums []int) []int {
	n := len(nums)

	result := make([]int, n)

	positiveIndex := 0
	negativeIndex := 1

	for i := 0; i < n; i++ {
		if nums[i] > 0 {
			result[positiveIndex] = nums[i]
			positiveIndex += 2
		} else {
			result[negativeIndex] = nums[i]
			negativeIndex += 2
		}
	}

	return result
}
