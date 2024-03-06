package medium

func detectCycle(head *ListNode) *ListNode {
	hashSet := make(map[*ListNode]bool, 0)

	current := head
	for current != nil {
		if hashSet[current] {
			return current
		}

		hashSet[current] = true

		current = current.Next
	}

	return nil
}
