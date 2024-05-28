package word_breaker

import "strings"

var result []string

func wordBreak(s string, wordDict []string) []string {
	result=make([]string, 0)

	wordSet:=make(map[string]struct{}, 0)

	for _, word:=range wordDict {
		wordSet[word] = struct{}{}
	}

	traverse(0, s, wordSet, []byte{}, "", 0)

	return result
}

func traverse(i int, s string, wordSet map[string]struct{}, current []byte, currentResult string, spaceCount int) {
	if i == len(s) {
		if len(currentResult)!=0 && len(s)-1 == len(currentResult)-spaceCount {
			result = append(result, currentResult)
		}
		return
	}

	newCurrent := append(current, s[i])

	key:=string(newCurrent)
	_, ok:=wordSet[key]

	// check that we can devide at this i
	if ok {
		if len(currentResult) == 0 {
			traverse(i+1, s, wordSet, []byte{}, key, spaceCount+1)
		} else {
			newResult:=strings.Join([]string{currentResult, " ", key}, "")
			traverse(i+1, s, wordSet, []byte{}, newResult, spaceCount+1)
		}
	}

	traverse(i+1, s, wordSet, newCurrent, currentResult, spaceCount)
}