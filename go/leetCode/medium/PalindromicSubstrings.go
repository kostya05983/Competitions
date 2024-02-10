package medium

func countSubstrings(s string) int {
	count := 0

	for i := 0; i < len(s); i++ {
		var left = i
		var right = i

		for left >= 0 && right < len(s) && s[left] == s[right] {
			left--
			right++
			count++
		}

		left = i
		right = i + 1
		for left >= 0 && right < len(s) && s[left] == s[right] {
			left--
			right++
			count++
		}
	}

	return count
}
