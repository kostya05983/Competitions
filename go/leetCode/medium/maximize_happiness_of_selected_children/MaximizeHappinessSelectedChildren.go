package maximize_happiness_of_selected_children

import "sort"

func maximumHappinessSum(happiness []int, k int) int64 {
	sort.Ints(happiness)

	right := len(happiness) - 1

	var result int64 = 0
	for ; right > len(happiness)-k-1; right-- {
		add := int64(happiness[right] - (len(happiness) - 1 - right))
		if add > 0 {
			result += add
		}
	}

	return result
}
