package easy

import (
	"strings"
)

func capitalizeTitle(title string) string {
	var words = strings.Split(title, " ")
	result := make([]string, len(words))

	for i, word := range words {
		if len(word) > 2 {
			result[i] = strings.Title(strings.ToLower(word))
		} else {
			result[i] = strings.ToLower(word)
		}
	}

	return strings.Join(result, " ")
}
