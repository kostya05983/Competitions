package easy

func diameterOfBinaryTree(root *TreeNode) int {
	diameter :=0
	traverse(root, &diameter)

	return diameter
}

func traverse(root *TreeNode, diameter *int) int {
	if root == nil {
		return 0
	}

	left := traverse(root.Left, diameter)
	right := traverse(root.Right, diameter)

	*diameter = max(*diameter, left+right)

	return max(left, right) + 1
}
