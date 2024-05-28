package word_pattern_2

import "strings"

func wordPatternMatch(pattern string, s string) bool {
	symbolMap := make(map[uint8]string, 0)
	wordSet := make(map[string]struct{}, 0)

	return isMatch(s, 0, pattern, 0, symbolMap, wordSet)
}

func isMatch(s string, sIndex int, pattern string, pIndex int, symbolMap map[uint8]string, wordSet map[string]struct{}) bool {
	if pIndex == len(pattern) {
		return sIndex == len(s)
	}

	symbol := pattern[pIndex]

	word, ok := symbolMap[symbol]
	if ok {
		if !strings.HasPrefix(s[sIndex:], word) {
			return false
		}

		return isMatch(s, sIndex+len(word), pattern, pIndex+1, symbolMap, wordSet)
	}

	for k := sIndex + 1; k <= len(s); k++ {
		newWord := s[sIndex:k]
		_, ok := wordSet[newWord]
		if ok {
			continue
		}
		symbolMap[symbol] = newWord
		wordSet[newWord] = struct{}{}

		if isMatch(s, k, pattern, pIndex+1, symbolMap, wordSet) {
			return true
		}

		delete(symbolMap, symbol)
		delete(wordSet, newWord)
	}

	return false
}
