package easy

func maxDepth(s string) int {
	count := 0

	maxCount := 0

	for _, ch := range s {
		if ch == '(' {
			count++
		}
		if ch ==')' {
			count--
		}
		maxCount = max(maxCount, count)
	}

	return maxCount
}
