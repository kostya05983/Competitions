package medium

import (
	"sort"
)

type MaxHeap []int

func (h MaxHeap) Len() int           { return len(h) }
func (h MaxHeap) Less(i, j int) bool { return h[i] > h[j] }
func (h MaxHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *MaxHeap) Push(x any) {
	// Push and Pop use pointer receivers because they modify the slice's length,
	// not just its contents.
	*h = append(*h, x.(int))
}

func (h *MaxHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func leastInterval(tasks []byte, n int) int {
	frequency := make([]int, 26)

	for _, task := range tasks {
		frequency[task-'A']++
	}
	sort.Ints(frequency)

	maxFrequency := frequency[25]
	idleCount := (maxFrequency - 1) * n

	for i := 24; i >= 0 && frequency[i] > 0; i-- {
		idleCount -= min(maxFrequency-1, frequency[i])
	}
	idleCount = max(0, idleCount)

	return len(tasks) + idleCount
}
