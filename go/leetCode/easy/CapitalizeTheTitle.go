package easy

import (
	"strings"
	"unicode"
)

func capitalizeTitle(title string) string {
	var words = strings.Split(title, " ")

	var sb = strings.Builder{}

	for i, word := range words {
		if len(word) > 2 {
			sb.WriteRune(unicode.ToUpper(rune(word[0])))
			sb.WriteString(strings.ToLower(word[1:]))
		} else {
			sb.WriteString(strings.ToLower(word))
		}
		if i != len(words)-1 {
			sb.WriteRune(' ')
		}
	}

	return sb.String()
}
