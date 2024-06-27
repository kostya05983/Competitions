package find_center_of_star_graph

func findCenter(edges [][]int) int {
	frequencyCount := make(map[int]int, 0)

	for _, edge := range edges {
		frequencyCount[edge[0]]++
		frequencyCount[edge[1]]++
	}

	for key, value := range frequencyCount {
		if value == len(frequencyCount)-1 {
			return key
		}
	}

	return -1
}
