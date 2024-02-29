package medium

func isEvenOddTree(root *TreeNode) bool {
	nodesByLevels := make([][]int, 0)

	traverseEvenOdd(root, 0, &nodesByLevels)

	for i, row := range nodesByLevels {
		n := len(row)

		if n == 1 && (i%2 == 0 && row[0]%2 == 0 || i%2 == 1 && row[0]%2 != 0) {
			return false
		}

		for j := 0; j < n-1; j++ {
			value := row[j]
			next := row[j+1]

			isIncreasing := value%2 == 0 || next%2 == 0 || value >= next
			isDecreasing := value%2 != 0 || next%2 != 0 || value <= next

			if i%2 == 0 && isIncreasing {
				return false
			}
			if i%2 != 0 && isDecreasing {
				return false
			}

		}
	}

	return true
}

func traverseEvenOdd(root *TreeNode, depth int, result *[][]int) {
	if root == nil {
		return
	}

	if len(*result) == depth {
		*result = append(*result, make([]int, 0))
	}

	(*result)[depth] = append((*result)[depth], root.Val)

	traverseEvenOdd(root.Left, depth+1, result)
	traverseEvenOdd(root.Right, depth+1, result)
}
