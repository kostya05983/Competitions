package medium

import (
	"sort"
	"strings"
)

type Pair struct {
	key   rune
	value int
}

func frequencySort(s string) string {
	var frequencies = make(map[rune]int)

	for _, char := range s {
		frequencies[char] = frequencies[char] + 1
	}

	frequenciesList := make([]Pair, 0, len(frequencies))

	for key, value := range frequencies {
		frequenciesList = append(frequenciesList, Pair{key, value})
	}

	sort.Slice(frequenciesList, func(i, j int) bool {
		return frequenciesList[i].value > frequenciesList[j].value
	})

	var sb strings.Builder

	for _, item := range frequenciesList {
		for i := 0; i < item.value; i++ {
			sb.WriteRune(item.key)
		}
	}

	return sb.String()
}
