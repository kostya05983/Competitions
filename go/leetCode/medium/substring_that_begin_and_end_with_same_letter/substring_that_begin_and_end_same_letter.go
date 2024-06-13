package substring_that_begin_and_end_with_same_letter

func numberOfSubstrings(s string) int64 {
	frequencies := make(map[rune]int, 0)

	for _, ch := range s {
		frequencies[ch]++
	}

	var result int64

	for _, value := range frequencies {
		if value > 1 {
			result += int64(sum(value - 1))
		}
	}

	return result + int64(len(s))
}

func sum(i int) int {
	result := 0

	start := 1
	for i > 0 {
		result += start
		start++
		i--
	}

	return result
}
