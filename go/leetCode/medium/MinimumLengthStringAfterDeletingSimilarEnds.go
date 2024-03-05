package medium

func minimumLength(s string) int {
	n := len(s)
	left := 0
	right := n - 1

	for left < right {
		if s[left] != s[right] {
			return right - left + 1
		}

		for left < n-1 && s[left] == s[left+1] {
			left++
		}
		for right > 0 && s[right] == s[right-1] {
			right--
		}
		left++
		right--
	}

	if left == right {
		return 1
	}

	return 0
}
