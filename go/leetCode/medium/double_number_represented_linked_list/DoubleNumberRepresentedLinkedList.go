package double_number_represented_linked_list

type ListNode struct {
	Val  int
	Next *ListNode
}

func doubleIt(head *ListNode) *ListNode {
	reversed := reverseList(head)

	remain := 0

	current := reversed
	var prev *ListNode
	for current != nil {
		doubleValue := current.Val*2 + remain

		remain = doubleValue / 10
		current.Val = doubleValue % 10
		prev = current
		current = current.Next
	}
	if remain != 0 {
		prev.Next = &ListNode{
			Val: remain,
		}
	}

	return reverseList(reversed)
}

func reverseList(head *ListNode) *ListNode {
	var prev *ListNode
	for head != nil {
		next := head.Next
		head.Next = prev
		prev, head = head, next
	}
	return prev
}
