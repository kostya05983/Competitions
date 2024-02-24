package hard

import "sort"

func findAllPeople(n int, meetings [][]int, firstPerson int) []int {
	groupedByTime := make(map[int]map[int][]int, 0)

	for _, v := range meetings {
		time := v[2]
		from := v[0]
		to := v[1]

		value, exist := groupedByTime[time]
		if !exist {
			value = make(map[int][]int, 0)
		}
		value[from] = append(value[from], to)
		value[to] = append(value[to], from)

		groupedByTime[time] = value
	}

	keys := make([]int, len(groupedByTime))
	for key := range groupedByTime {
		keys = append(keys, key)
	}

	sort.Ints(keys)

	knowSecretSet := map[int]bool{0: true, firstPerson: true}

	for _, v := range keys {
		group := groupedByTime[v]

		whoKnows := make([]int, 0)

		for from, _ := range group {
			_, know := knowSecretSet[from]
			if know {
				whoKnows = append(whoKnows, from)
			}
		}

		if len(whoKnows) == 0 {
			continue
		}

		for _, know := range whoKnows {
			visited := make(map[int]bool, 0)
			graphSearch(know, group, visited, knowSecretSet)
		}
	}

	knowSecretResult := make([]int, 0)

	for key := range knowSecretSet {
		knowSecretResult = append(knowSecretResult, key)
	}

	return knowSecretResult
}

func graphSearch(firstPerson int, graph map[int][]int, visited map[int]bool, knowSecretSet map[int]bool) {
	_, ok := visited[firstPerson]
	if ok {
		return
	}
	visited[firstPerson] = true

	neighbours, ok := graph[firstPerson]
	if !ok {
		return
	}

	for _, value := range neighbours {
		knowSecretSet[value] = true
		graphSearch(value, graph, visited, knowSecretSet)
	}
}
