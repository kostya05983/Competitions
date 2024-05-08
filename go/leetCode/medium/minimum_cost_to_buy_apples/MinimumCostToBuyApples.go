package minimum_cost_to_buy_apples

type Node struct {
	to   int
	cost int
}

func minCost(n int, roads [][]int, appleCost []int, k int) []int64 {

	graph := make(map[int]Node, 0)

	for _, v := range roads {
		graph[v[0]] = Node{
			to:   v[1],
			cost: v[2],
		}
		graph[v[1]] = Node{
			to:   v[0],
			cost: v[2],
		}
	}

	for i := 1; i <= n; i++ {

	}

	return []int64{}
}

func bestCityPrice(start int, graph map[int][]Node) int {
	distances := make(map[int]int, 0)
	//todo надо по дефолту заполнить бесконечностями, можно так же превратить это в массив

	distances[start] = 0

	queue := make([]Node, 0)
	queue = append(queue, Node{start, 0})

	for len(queue) > 0 {
		popped := queue[0]
		queue = queue[1:]

		if popped.cost > distances[popped.to] {
			continue
		}

		paths := graph[popped.to]

		for _, v := range paths {
			distance := popped.cost + v.cost

			if distance < distances[v.to] {
				distances[v.to] = distance
				//heap.Push(queue, Node{distance, v.to})

				//todo тут где-то считаем и находим минимальную стоимость
			}
		}
	}
	return 0
}
