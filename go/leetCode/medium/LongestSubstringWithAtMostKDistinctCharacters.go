package medium

func lengthOfLongestSubstringKDistinct(s string, k int) int {
	right := 0
	left := 0
	set := make(map[byte]int, 0)
	maxLen := 0

	for ; right < len(s); right++ {
		ch := s[right]
		set[ch]++

		for len(set) > k {
			leftCh := s[left]
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
