package hexspeak_representation

import (
	"fmt"
	"strconv"
	"strings"
)

func toHexspeak(num string) string {
	n, _ := strconv.Atoi(num)
	hex := strings.ToUpper(fmt.Sprintf("%x", n))
	replacedHex := make([]rune, 0)

	allowRunes := map[rune]bool{
		'A': true,
		'B': true,
		'C': true,
		'D': true,
		'E': true,
		'F': true,
		'I': true,
		'O': true,
	}

	for _, v := range hex {
		switch {
		case v == '1':
			replacedHex = append(replacedHex, 'I')
		case v == '0':
			replacedHex = append(replacedHex, 'O')
		case allowRunes[v]:
			replacedHex = append(replacedHex, v)
		default:
			return "ERROR"
		}
	}

	return string(replacedHex)
}
