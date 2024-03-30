package medium

func lengthOfLongestSubstringKDistinct(s string, k int) int {
	runes := []rune(s)
	right := 0
	left := 0
	set := make(map[rune]int, 0)
	maxLen := 0

	for ; right < len(runes); right++ {
		ch := runes[right]
		set[ch]++

		for len(set) > k {
			leftCh := runes[left]
			set[leftCh]--

			v, ok := set[leftCh]
			if ok && v == 0 {
				delete(set, leftCh)
			}
			left++
		}

		maxLen = max(maxLen, right-left+1)
	}

	return maxLen
}
