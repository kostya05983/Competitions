package easy

import (
	"strings"
	"unicode"
)

func toLowerCase(s string) string {
	result := strings.Builder{}

	for _, ch := range s {
		result.WriteRune(unicode.ToLower(ch))
	}

	return result.String()
}
