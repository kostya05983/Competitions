package medium

import "sort"

func customSortString(order string, s string) string {
	ordersMap := make(map[rune]int, 0)

	for i, ch := range order {
		ordersMap[ch] = i
	}

	runes := []rune(s)

	sort.Slice(runes, func(i, j int) bool {
		return ordersMap[runes[i]] < ordersMap[runes[j]]
	})

	return string(runes)
}
