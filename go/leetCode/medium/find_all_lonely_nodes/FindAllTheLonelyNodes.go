package find_all_lonely_nodes

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func getLonelyNodes(root *TreeNode) []int {
	result := make([]int, 0)
	traverse(root, false, &result)

	return result
}

func traverse(root *TreeNode, isLonely bool, result *[]int) {
	if root == nil {
		return
	}

	if isLonely {
		*result = append(*result, root.Val)
	}

	left := root.Left
	right := root.Right

	willBeLonely := left == nil && right != nil || left != nil && right == nil
	traverse(left, willBeLonely, result)
	traverse(right, willBeLonely, result)
}
