package medium

func rotateRight(head *ListNode, k int) *ListNode {
	if k == 0 {
		return head
	}

	current := head
	length := 0

	previousMap := make(map[*ListNode]*ListNode, 0)
	var previous *ListNode
	for current != nil {
		length++
		previousMap[current] = previous
		previous = current
		current = current.Next
	}
	if length == 0 || length == 1 || length == k {
		return head
	}

	decreasedK := k % length
	if decreasedK == 0 {
		return head
	}

	end := previous
	for decreasedK > 0 {
		previous = previousMap[previous]
		decreasedK--
	}

	newHead := previous.Next
	previous.Next = nil
	end.Next = head

	return newHead
}
