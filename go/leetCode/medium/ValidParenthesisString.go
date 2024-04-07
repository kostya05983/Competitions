package medium

func CheckValidString(s string) bool {
	return checkValidString(s)
}

func checkValidString(s string) bool {
	openLeft := 0
	leftStack := make([]int, 0)
	freeAny := 0
	anyStack := make([]int, 0)

	for i, ch := range s {
		switch ch {
		case '(':
			openLeft++
			leftStack = append(leftStack, i)
		case ')':
			if openLeft > 0 {
				openLeft--
				leftStack = leftStack[:len(leftStack)-1]
			} else if freeAny > 0 {
				freeAny--
				anyStack = anyStack[:len(anyStack)-1]
			} else {
				return false
			}
		default:
			freeAny++
			anyStack = append(anyStack, i)
		}
	}

	for openLeft > 0 && len(leftStack) > 0 && len(anyStack) > 0 {
		leftIndex := leftStack[len(leftStack)-1]
		anyIndex := anyStack[len(anyStack)-1]

		if leftIndex < anyIndex {
			openLeft-- // doubted
			leftStack = leftStack[:len(leftStack)-1]
			anyStack = anyStack[:len(anyStack)-1]
		} else {
			break
		}
	}

	if openLeft > 0 {
		return false
	} else {
		return true
	}
}
