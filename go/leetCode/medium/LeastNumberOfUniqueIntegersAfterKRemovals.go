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

	index := 0
	n := len(frequenciesList)
	for k > 0 && index < n {
		frequency := frequenciesList[index]
		frequenciesList[index].second = frequency.second - 1
		if frequency.second == 1 {
			index++
		}
		k--
	}

	result := 0
	for _, num := range frequenciesList {
		if num.second > 0 {
			result++
		}
	}

	return result
}
