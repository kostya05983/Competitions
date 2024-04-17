package smallest_string_starting_from_leaf

import (
	"strings"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func smallestFromLeaf(root *TreeNode) string {
	var result []int

	traverse(root, []int{}, &result)

	return toString(result)
}

func traverse(root *TreeNode, current []int, result *[]int) {
	if root == nil {
		return
	}
	left := root.Left
	right := root.Right

	newCurrent := make([]int, 0, len(current)+1)
	newCurrent = append(newCurrent, current...)
	newCurrent = append(newCurrent, root.Val)

	if left == nil && right == nil {
		if *result == nil {
			*result = newCurrent
		} else {
			newCurrentStr := toString(newCurrent)
			resultStr := toString(*result)

			if strings.Compare(newCurrentStr, resultStr) == -1 {
				*result = newCurrent
			}
		}
	}

	traverse(left, newCurrent, result)
	traverse(right, newCurrent, result)
}

func toString(numbers []int) string {
	i := len(numbers) - 1

	result := make([]rune, 0)

	for i >= 0 {
		result = append(result, rune(97+numbers[i]))
		i--
	}

	return string(result)
}
