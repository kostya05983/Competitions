package easy

func removeVowels(s string) string {
	vowels := map[rune]bool{'a': true, 'e': true, 'i': true, 'o': true, 'u': true}

	result := make([]rune, 0)

	for _, ch := range s {
		if !vowels[ch] {
			result = append(result, ch)
		}
	}

	return string(result)
}
