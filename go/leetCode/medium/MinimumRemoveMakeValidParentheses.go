package medium

type Bracket struct {
	index int
	ch    rune
}

func minRemoveToMakeValid(s string) string {
	brackets := make([]Bracket, 0)

	result := make([]rune, 0)

	for _, ch := range s {
		if ch == ')' {
			if len(brackets) == 0 {
				continue
			}
			leftBracket := brackets[len(brackets)-1]

			if leftBracket.ch != '(' {
				continue
			}

			if leftBracket.ch == '(' {
				brackets = brackets[:len(brackets)-1]
				result = append(result, ch)
				continue
			}
		}

		result = append(result, ch)

		if ch == '(' {
			brackets = append(brackets, Bracket{len(result) - 1, ch})
		}
	}

	for len(brackets) > 0 {
		bracket := brackets[len(brackets)-1]

		if bracket.index == 0 {
			result = result[1:]
		} else {
			result = append(result[:bracket.index], result[bracket.index+1:]...)
		}

		brackets = brackets[:len(brackets)-1]
	}

	return string(result)
}
