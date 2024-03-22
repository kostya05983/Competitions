package easy

import "unicode"

func isPalindrome2(s string) bool {
	runes := []rune(s)

	left := 0
	right := len(s) - 1

	for left < right {
		leftCh := runes[left]
		rightCh := runes[right]

		if !unicode.IsLetter(leftCh) && !unicode.IsDigit(leftCh) {
			left++
			continue
		}

		if !unicode.IsLetter(rightCh) && !unicode.IsDigit(rightCh) {
			right--
			continue
		}

		if unicode.ToLower(leftCh) != unicode.ToLower(rightCh) {
			return false
		}
		left++
		right--
	}

	return true
}
