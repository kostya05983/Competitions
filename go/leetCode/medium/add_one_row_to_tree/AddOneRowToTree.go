package add_one_row_to_tree

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func addOneRow(root *TreeNode, val int, depth int) *TreeNode {
	if depth == 1 {
		return &TreeNode{val, root, nil}
	}

	traverse(root, val, 1, depth)

	return root
}

func traverse(root *TreeNode, val int, current int, depth int) {
	if root == nil {
		return
	}

	left := root.Left
	right := root.Right

	if current == depth-1 {
		newLeft := TreeNode{val, left, nil}
		newRight := TreeNode{val, nil, right}
		root.Left = &newLeft
		root.Right = &newRight
		return
	}

	traverse(left, val, current+1, depth)
	traverse(right, val, current+1, depth)
}
