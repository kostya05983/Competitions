package medium

func removeZeroSumSublists(head *ListNode) *ListNode {
	result := ListNode{0, head}
	left := &result

	for left != nil {
		prefixSum := 0
		right := left.Next

		for right != nil {
			prefixSum += right.Val

			if prefixSum == 0 {
				left.Next = right.Next
			}
			right = right.Next
		}

		left = left.Next
	}

	return result.Next
}
