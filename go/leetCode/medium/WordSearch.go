package medium

func exist(board [][]byte, word string) bool {
	firstCh := word[0]

	for i, row := range board {
		for j, col := range row {
			if col == firstCh {
				visited := createVisited(board)

				result := traverseBoard(board, visited, word, 0, i, j)
				if result {
					return true
				}
			}
		}
	}

	return false
}

func createVisited(board [][]byte) [][]bool {
	visited := make([][]bool, len(board))
	for vI := range visited {
		visited[vI] = make([]bool, len(board[0]))
	}

	return visited
}

func traverseBoard(board [][]byte, visited [][]bool, word string, wordIndex int, r int, c int) bool {
	if wordIndex >= len(word) {
		return true
	}

	if r < 0 || r >= len(board) {
		return false
	}
	if c < 0 || c >= len(board[0]) {
		return false
	}

	if word[wordIndex] != board[r][c] {
		return false
	}

	if visited[r][c] {
		return false
	}

	visited[r][c] = true

	result := false

	rMoves := []int{1, -1, 0, 0}
	cMoves := []int{0, 0, 1, -1}

	for i, _ := range rMoves {
		result = result || traverseBoard(board, visited, word, wordIndex+1, r+rMoves[i], c+cMoves[i])
		if result {
			break
		}
	}

	visited[r][c] = false

	return result
}
