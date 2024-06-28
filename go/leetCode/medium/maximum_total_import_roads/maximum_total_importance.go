package maximum_total_import_roads

import (
	"sort"
)

type Node struct {
	value     int
	frequency int
	priority  int
}

func maximumImportance(n int, roads [][]int) int64 {
	frequencies := make([]Node, n)

	for _, road := range roads {
		frequencies[road[0]].value = road[0]
		frequencies[road[0]].frequency++
		frequencies[road[1]].value = road[1]
		frequencies[road[1]].frequency++
	}

	sort.Slice(frequencies, func(i, j int) bool {
		return frequencies[i].frequency > frequencies[j].frequency
	})

	priority := n
	for i := range frequencies {
		frequencies[i].priority = priority
		priority--
	}

	priorityMap := make(map[int]int, 0)
	for _, frequency := range frequencies {
		if frequency.frequency!=0 {
			priorityMap[frequency.value] = frequency.priority
		}

	}

	var result int64 = 0
	for _, road := range roads {
		result += int64(priorityMap[road[0]])
		result += int64(priorityMap[road[1]])
	}

	return result
}