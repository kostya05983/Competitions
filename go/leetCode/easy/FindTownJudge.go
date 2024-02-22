package easy

func findJudge(n int, trust [][]int) int {
	if n == 1 && len(trust) == 0 {
		return 1
	}

	graph := make(map[int]int)
	leftSet := make(map[int]bool)

	for _, v := range trust {
		graph[v[1]] = graph[v[1]] + 1
		leftSet[v[0]] = true
	}

	for k, v := range graph {
		_, ok := leftSet[k]
		if v == n-1 && !ok {
			return k
		}
	}

	return -1
}
