package minimum_cost_to_hire_k_workers

import (
	"container/heap"
	"math"
	"sort"
)

type Worker struct {
	ratio   float64
	quality int
}

type MinHeap []int

func (h MinHeap) Len() int           { return len(h) }
func (h MinHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h MinHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *MinHeap) Push(x any) {
	*h = append(*h, x.(int))
}

func (h *MinHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func mincostToHireWorkers(quality []int, wage []int, k int) float64 {
	result := math.MaxFloat64
	current := 0.0

	workers := make([]Worker, len(quality))

	for i := range quality {
		workers[i] = Worker{float64(wage[i]) / float64(quality[i]), quality[i]}
	}

	sort.Slice(workers, func(i, j int) bool {
		return workers[i].ratio > workers[j].ratio
	})

	highestWorkers := MinHeap{}

	for i := 0; i < len(quality); i++ {
		heap.Push(&highestWorkers, workers[i].quality)

		current += float64(workers[i].quality)

		if len(highestWorkers) > k {
			popped := heap.Pop(&highestWorkers).(int)
			current -= float64(popped)
		}

		if len(highestWorkers) == k {
			result = min(result, current*workers[i].ratio)
		}
	}

	return result
}
