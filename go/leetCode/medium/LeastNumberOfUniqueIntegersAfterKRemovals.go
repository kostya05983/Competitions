package medium

import "sort"

type pair struct {
	first, second int
}

func findLeastNumOfUniqueInts(arr []int, k int) int {
	frequencies := make(map[int]int)

	for _, num := range arr {
		frequencies[num] = frequencies[num] + 1
	}

	frequenciesList := make([]pair, 0, len(frequencies))

	for key, value := range frequencies {
		frequenciesList = append(frequenciesList, pair{key, value})
	}

	sort.Slice(frequenciesList, func(i, j int) bool {
		return frequenciesList[i].second < frequenciesList[j].second
	})

	for i, _ := range frequenciesList {
		k -= frequenciesList[i].second

		if k < 0 {
			return len(frequenciesList) - i
		}
	}

	return 0
}
