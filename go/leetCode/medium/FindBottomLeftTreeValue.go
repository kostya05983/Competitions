package medium

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func findBottomLeftValue(root *TreeNode) int {
	result := 0
	maxDepth := -1
	traverse(root, 0, &maxDepth, &result)

	return result
}

func traverse(root *TreeNode, depth int, maxDepth *int, leftMostValue *int) {
	if root == nil {
		return
	}

	if depth > *maxDepth {
		*maxDepth = depth
		*leftMostValue = root.Val
	}

	traverse(root.Left, depth+1, maxDepth, leftMostValue)
	traverse(root.Right, depth+1, maxDepth, leftMostValue)
}
