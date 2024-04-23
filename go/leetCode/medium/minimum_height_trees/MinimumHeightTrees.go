package minimum_height_trees

func findMinHeightTrees(n int, edges [][]int) []int {
	if len(edges) == 0 {
		return []int{0}
	}

	nodesMap := make(map[int][]int, 0)
	degree := make(map[int]int, 0)
	for _, v := range edges {
		to, ok := nodesMap[v[0]]
		if !ok {
			nodesMap[v[0]] = make([]int, 0)
		}
		nodesMap[v[0]] = append(to, v[1])
		degree[v[0]]++

		from, ok := nodesMap[v[1]]
		if !ok {
			nodesMap[v[1]] = make([]int, 0)
		}
		nodesMap[v[1]] = append(from, v[0])
		degree[v[1]]++
	}

	toDelete := make([]int, 0)
	for key, value := range degree {
		if value == 1 {
			toDelete = append(toDelete, key)
		}
	}

	deleted := 0

	for n-deleted > 2 {
		deleted += len(toDelete)
		temp := make([]int, 0)

		for _, key := range toDelete {
			value := nodesMap[key]

			for _, v := range value {
				degree[v]--
				if degree[v] == 1 {
					temp = append(temp, v)
				}
			}

		}
		toDelete = temp
	}

	result := make([]int, 0)
	for key, _ := range nodesMap {
		result = append(result, key)
	}

	return result
}
