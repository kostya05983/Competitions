package sum_root_leaf_numbers

import (
	"fmt"
	"strconv"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func sumNumbers(root *TreeNode) int {
	return traverse(root, "")
}

func traverse(root *TreeNode, current string) int {
	if root == nil {
		return 0
	}

	left := root.Left
	right := root.Right

	newStr := fmt.Sprintf("%s%d", current, root.Val)

	if left == nil && right == nil {
		num, err := strconv.Atoi(current)
		if err != nil {
			panic(err)
		}
		return num
	}

	return traverse(left, newStr) + traverse(right, newStr)
}
