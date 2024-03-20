package medium

func mergeInBetween(list1 *ListNode, a int, b int, list2 *ListNode) *ListNode {
	var beforeA, afterB *ListNode

	current := list1
	index := 0

	for current != nil {
		if index == a-1 {
			beforeA = current
		}
		if index == b+1 {
			afterB = current
		}

		index++
		current = current.Next
	}

	list2Tail := list2

	for list2Tail.Next != nil {
		list2Tail = list2Tail.Next
	}

	if beforeA == nil {
		afterB.Next = list2Tail
		return afterB
	} else {
		beforeA.Next = list2
		list2Tail.Next = afterB
		return list1
	}
}
