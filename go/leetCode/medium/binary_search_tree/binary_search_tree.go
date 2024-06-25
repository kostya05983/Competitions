package binary_search_tree

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func bstToGst(root *TreeNode) *TreeNode {
	zero := 0
	traverse(root, &zero)

	return root
}

func traverse(root *TreeNode, add *int) int {
	if root == nil {
		return 0
	}

	right := traverse(root.Right, add)

	root.Val = root.Val + right + *add
	*add = 0

	newValue := root.Val

	left := traverse(root.Left, &newValue)

	return max(root.Val, left)
}
