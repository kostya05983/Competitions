package medium

import "fmt"

func printTree(root *TreeNode) [][]string {
	height := 0
	maxDepth(root, 0, &height)

	result := make([][]string, height+1)
	rowLength := getNumSize(height)
	for i := range result {
		result[i] = make([]string, rowLength)
	}

	collect(root, (rowLength-1)/2, 0, height, result)

	return result
}

func maxDepth(root *TreeNode, depth int, result *int) {
	if root == nil {
		return
	}
	if root.Left == nil && root.Right == nil {
		*result = max(*result, depth)
	}

	maxDepth(root.Left, depth+1, result)
	maxDepth(root.Right, depth+1, result)
}

func collect(root *TreeNode, index int, depth int, height int, matrix [][]string) {
	if root == nil {
		return
	}

	matrix[depth][index] = fmt.Sprintf("%d", root.Val)

	leftIndex := getLeftIndex(index, height, depth)
	collect(root.Left, leftIndex, depth+1, height, matrix)

	rightIndex := getRightIndex(index, height, depth)
	collect(root.Right, rightIndex, depth+1, height, matrix)
}

func getLeftIndex(current int, height int, depth int) int {
	result := pow2(height, depth)

	return current - result
}

func getRightIndex(current int, height int, depth int) int {
	result := pow2(height, depth)

	return current + result
}

var powMatrix =map[int]int{0: 1, 1:2, 2:4, 3:8, 4:16, 5:32, 6:64, 7:128, 8:256, 9:512, 10:1024}

func pow2(height int, depth int) int {
	degree := height - depth - 1

	return powMatrix[degree]
}

func getNumSize(depth int) int {
	result := 1
	sum := 1
	for depth > 0 {
		result *= 2
		sum += result
		depth--
	}

	return sum
}