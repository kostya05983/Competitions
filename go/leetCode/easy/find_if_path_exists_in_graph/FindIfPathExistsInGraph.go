package find_if_path_exists_in_graph

func validPath(n int, edges [][]int, source int, destination int) bool {
	paths := make(map[int][]int, 0)
	for i := 0; i < n; i++ {
		paths[i] = make([]int, 0)
	}

	visited := make([]bool, n)
	for i := range edges {
		key := edges[i][0]
		value := edges[i][1]

		paths[key] = append(paths[key], value)
		paths[value] = append(paths[value], key)
	}

	return search(source, paths, visited, destination)
}

func search(current int, paths map[int][]int, visited []bool, destination int) bool {
	if current == destination {
		return true
	}

	value := paths[current]
	if value == nil {
		return false
	}
	if visited[current] {
		return false
	}

	visited[current] = true

	anyFound := false
	for _, v := range value {
		anyFound = anyFound || search(v, paths, visited, destination)
	}

	return anyFound
}
