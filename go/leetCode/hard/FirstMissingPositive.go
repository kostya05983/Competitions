package hard

func firstMissingPositive(nums []int) int {
	temp := make([]bool, len(nums)+1)

	for _, v := range nums {
		if v < 0 || v > len(nums) {
			continue
		}
		temp[v] = true
	}

	for i, v := range temp {
		if !v && i != 0 {
			return i
		}
	}

	return len(temp)
}
