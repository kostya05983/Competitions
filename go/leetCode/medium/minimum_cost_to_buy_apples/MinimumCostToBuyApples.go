package minimum_cost_to_buy_apples

import (
	"container/heap"
	"math"
)

type Node struct {
	to   int
	cost int
}

func minCost(n int, roads [][]int, appleCost []int, k int) []int64 {
	graph := make(map[int][]Node, 0)

	for _, v := range roads {
		from := v[0] - 1
		to := v[1] - 1

		_, ok := graph[from]
		if !ok {
			graph[from] = make([]Node, 0)
		}

		_, ok = graph[to]
		if !ok {
			graph[to] = make([]Node, 0)
		}

		graph[from] = append(graph[from], Node{
			to:   to,
			cost: v[2],
		})

		graph[to] = append(graph[to], Node{
			to:   from,
			cost: v[2],
		})
	}

	result := make([]int64, n)
	for i := 0; i < n; i++ {
		result[i] = bestCityPrice(i, graph, appleCost, k, n)
	}

	return result
}

type IntHeap [][]int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i][0] < h[j][0] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }
func (h *IntHeap) Push(x any) {
	// Push and Pop use pointer receivers because they modify the slice's length,
	// not just its contents.
	*h = append(*h, x.([]int))
}

func (h *IntHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func bestCityPrice(start int, graph map[int][]Node, appleCost []int, k int, n int) int64 {
	travelCosts := make([]int, n)
	for i := range travelCosts {
		travelCosts[i] = math.MaxInt
	}
	travelCosts[start] = 0

	queue := IntHeap{}

	heap.Init(&queue)
	heap.Push(&queue, []int{0, start})
	var result int64 = math.MaxInt64

	for len(queue) > 0 {
		current := heap.Pop(&queue).([]int)
		travelCost := current[0]
		currentCity := current[1]

		multiply := int64(appleCost[currentCity]) + (int64(k)+1)*int64(travelCost)
		result = min(result, multiply)

		for _, v := range graph[currentCity] {
			neighbor := v.to
			nextCost := travelCost + v.cost
			if nextCost < travelCosts[neighbor] {
				travelCosts[neighbor] = nextCost
				heap.Push(&queue, []int{nextCost, neighbor})
			}
		}
	}

	return result
}
