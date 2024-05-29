package number_of_steps_to_reduce_number

func numSteps(s string) int {
	transformed := []rune(s)

	result := 0

	for len(transformed) != 1 || transformed[0] != 49 {
		if transformed[len(transformed)-1] == 49 {
			transformed = plusOne(transformed)
		} else {
			transformed = divide(transformed)
		}
		result++
	}

	return result
}

func divide(s []rune) []rune {
	for i := len(s) - 1; i > 0; i-- {
		s[i] = s[i-1]
	}

	return s[1:]
}

func plusOne(s []rune) []rune {
	remain := 1
	s[len(s)-1] = 48

	for i := len(s) - 2; i >= 0; i-- {
		if remain == 0 {
			break
		}
		if s[i] == 48 {
			s[i] = 49
			remain--
			break
		}
		if s[i] == 49 {
			s[i] = 0
		}
	}
	if remain == 1 {
		return append([]rune{'1'}, s...)
	}
	return s
}