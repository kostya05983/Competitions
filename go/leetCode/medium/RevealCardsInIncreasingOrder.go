package medium

import "sort"

func deckRevealedIncreasing(deck []int) []int {
	sort.Ints(deck)

	queue := make([]int, 0)
	for i := range deck {
		queue = append(queue, i)
	}

	result := make([]int, len(deck))
	index := 0

	for len(queue) > 0 {
		result[queue[0]] = deck[index]
		var toBottom *int
		if len(queue) >= 2 {
			toBottom = &queue[1]
		}

		if toBottom != nil {
			queue = append(queue, *toBottom)
			queue = queue[2:]
		} else {
			queue = queue[1:]
		}
		index++
	}

	return result
}
