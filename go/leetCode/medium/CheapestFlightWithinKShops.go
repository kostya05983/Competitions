package medium

import "math"

func findCheapestPrice(n int, flights [][]int, src int, dst int, k int) int {
	adjacency := make(map[int][][]int)

	for _, flight := range flights {
		adjacency[flight[0]] = append(adjacency[flight[0]], []int{flight[1], flight[2]})
	}

	distanation := make([]int, n)

	for i := 0; i < n; i++ {
		distanation[i] = math.MaxInt32
	}

	queue := make([][]int, 0)
	queue = append(queue, []int{src, 0})

	stops := 0

	for stops <= k && len(queue) != 0 {
		size := len(queue)

		for size > 0 {
			temp := queue[0]
			queue = queue[1:]
			size--

			node := temp[0]
			distance := temp[1]

			neighbours, ok := adjacency[node]
			if !ok {
				continue
			}

			for _, value := range neighbours {
				neighbour := value[0]
				price := value[1]

				if price+distance >= distanation[neighbour] {
					continue
				}

				distanation[neighbour] = price + distance
				queue = append(queue, []int{neighbour, distanation[neighbour]})
			}
		}
		stops++
	}

	if distanation[dst] == math.MaxInt32 {
		return -1
	} else {
		return distanation[dst]
	}
}
