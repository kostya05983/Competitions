package medium

type ListNode struct {
	Val  int
	Next *ListNode
}

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	result := make([]*ListNode, 0)

	current := head

	for current != nil {
		result = append(result, current)
		current = current.Next
	}

	end := len(result) - n

	switch {
	case end > 0 && end+1 < len(result):
		result[end-1].Next = result[end+1]
	case end == 0:
		head = head.Next
	default:
		result[end-1].Next = nil
	}

	return head
}
