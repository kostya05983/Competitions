package medium

func minimumLength(s string) int {
	n := len(s)
	left := 0
	right := n - 1

	for left < right {
		leftCh := s[left]
		rightCh := s[right]

		if leftCh != rightCh {
			break
		}

		for left <= right && s[left] == rightCh {
			left++
		}
		for right >= left && s[right] == leftCh {
			right--
		}
	}

	return right - left + 1
}
