package get_equal_substring_within_budget

func equalSubstring(s string, t string, maxCost int) int {
	diff := make([]uint8, len(s))

	for i := range s {
		if s[i] > t[i] {
			diff[i] = s[i] - t[i]
		} else {
			diff[i] = t[i] - s[i]
		}
	}

	left := 0
	right := 0

	maxLength := 0
	currentCost := 0
	for right < len(s) {
		if currentCost > maxCost {
			currentCost -= int(diff[left])
			left++
		}
		currentCost += int(diff[right])
		right++
		if currentCost <= maxCost {
			maxLength = max(maxLength, right-left)
		}
	}

	return maxLength
}
