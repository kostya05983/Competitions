package easy

func reverseList(head *ListNode) *ListNode {
	var newHead *ListNode

	current := head

	for current != nil {
		next := current.Next

		if newHead == nil {
			newHead = current
			current.Next = nil
		} else {
			current.Next = newHead
			newHead = current
		}

		current = next
	}

	return newHead
}
