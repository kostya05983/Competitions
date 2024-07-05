package find_the_minimum_and_maximum_number

import "math"

type ListNode struct {
	Val  int
	Next *ListNode
}

func nodesBetweenCriticalPoints(head *ListNode) []int {
	var previous *ListNode

	current := head
	indexes := make([]int, 0)
	index := 0
	minDistance := math.MaxInt

	for current != nil {
		next := current.Next

		if next != nil && previous != nil && ((previous.Val > current.Val && current.Val < next.Val) || (previous.Val < current.Val && current.Val > next.Val)) {
			if len(indexes) >= 1 {
				minDistance = min(minDistance, index-indexes[len(indexes)-1])
			}

			indexes = append(indexes, index)
		}
		index++
		previous = current
		current = next
	}

	if len(indexes) < 2 {
		return []int{-1, -1}
	}

	return []int{minDistance, indexes[len(indexes)-1] - indexes[0]}
}
