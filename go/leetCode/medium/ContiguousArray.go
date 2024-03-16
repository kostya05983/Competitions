package medium

func findMaxLength(nums []int) int {
	n := len(nums)

	countToIndex := make(map[int]int, 0)
	countToIndex[0] = -1
	count := 0
	result := 0

	for i := 0; i < n; i++ {
		if nums[i] == 1 {
			count++
		} else {
			count--
		}

		res, ok := countToIndex[count]
		if ok {
			result = max(result, i-res)
		} else {
			countToIndex[count] = i
		}
	}

	return result
}
