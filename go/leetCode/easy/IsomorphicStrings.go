package easy

func isIsomorphic(s string, t string) bool {
	firstSet := make(map[rune]rune, 0)
	secondSet := make(map[rune]rune, 0)

	tRunes := []rune(t)
	for i, ch := range s {
		alreadyMapped, ok := firstSet[ch]

		if ok && alreadyMapped != tRunes[i] {
			return false
		}

		reverseMapped, ok := secondSet[tRunes[i]]
		if ok && reverseMapped != ch {
			return false
		}

		firstSet[ch] = tRunes[i]
		secondSet[tRunes[i]] = ch
	}

	return true
}
