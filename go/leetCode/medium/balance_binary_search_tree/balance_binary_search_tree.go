package balance_binary_search_tree

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func balanceBST(root *TreeNode) *TreeNode {
	nodeValues := make([]int, 0)
	collect(root, &nodeValues)

	return buildTree(nodeValues, 0, len(nodeValues)-1)
}

func buildTree(nums []int, left int, right int) *TreeNode {
	if left > right {
		return nil
	}

	mid := (left + right) / 2

	root := &TreeNode{Val: nums[mid]}
	root.Left = buildTree(nums, left, mid-1)
	root.Right = buildTree(nums, mid+1, right)

	return root
}

func collect(root *TreeNode, result *[]int) {
	if root == nil {
		return
	}

	collect(root.Left, result)
	*result = append(*result, root.Val)
	collect(root.Right, result)
}
