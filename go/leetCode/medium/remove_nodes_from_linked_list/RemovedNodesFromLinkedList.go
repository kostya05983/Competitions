package remove_nodes_from_linked_list

type ListNode struct {
	Val  int
	Next *ListNode
}

func removeNodes(head *ListNode) *ListNode {
	stack := make([]*ListNode, 0)

	current := head
	for current != nil {
		stack = append(stack, current)
		current = current.Next
	}

	maxValue := -1

	temp := make([]*ListNode, 0)
	for len(stack) > 0 {
		popped := stack[len(stack)-1]
		stack = stack[:len(stack)-1]

		if popped.Val >= maxValue {
			temp = append(temp, &ListNode{
				Val: popped.Val,
			})
			maxValue = popped.Val
		}
	}

	var result = ListNode{}
	current = &result
	for i := len(temp) - 1; i >= 0; i-- {
		current.Next = &ListNode{Val: temp[i].Val}
		current = current.Next
	}

	return result.Next
}
