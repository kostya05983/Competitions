package easy

func firstPalindrome(words []string) string {
	for _, word := range words {
		if isPalindromic(word) {
			return word
		}
	}

	return ""
}

func isPalindromic(word string) bool {
	left := 0
	right := len(word) - 1

	for left < right {
		if word[left] != word[right] {
			return false
		}
		left++
		right--
	}

	return true
}
