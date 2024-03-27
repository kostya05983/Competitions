package easy

func frequenciesOfElements(head *ListNode) *ListNode {
	current := head

	frequencies := make(map[int]int, 0)
	for current != nil {
		frequencies[current.Val]++
		current = current.Next
	}

	result := &ListNode{0, nil}

	current = result
	for _, v := range frequencies {
		current.Next = &ListNode{v, nil}
		current = current.Next
	}

	return result.Next
}
