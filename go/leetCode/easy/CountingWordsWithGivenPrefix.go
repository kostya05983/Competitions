package easy

import "strings"

func prefixCount(words []string, pref string) int {
	result := 0

	for _, word := range words {
		if strings.HasPrefix(word, pref) {
			result++
		}
	}

	return result
}
