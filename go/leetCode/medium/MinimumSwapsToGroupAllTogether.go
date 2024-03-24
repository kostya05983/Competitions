package medium

func minSwaps(data []int) int {
	windowSize := 0

	for _, v := range data {
		if v == 1 {
			windowSize++
		}
	}

	right := windowSize - 1
	zeroCount := 0
	for i := 0; i < len(data); i++ {
		if data[i] == 0 {
			zeroCount++
		}
	}

	result := zeroCount

	for right-1 < len(data) {
		leftNum := data[right-windowSize]
		if leftNum == 0 {
			zeroCount--
		}
		right++

		rightNum := data[right]
		if rightNum == 0 {
			zeroCount++
		}

		result = min(result, zeroCount)
	}

	return result
}
