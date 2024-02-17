package medium

import (
	"container/heap"
)

// An IntHeap is a min-heap of ints.
type IntHeap []int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *IntHeap) Push(x any) {
	// Push and Pop use pointer receivers because they modify the slice's length,
	// not just its contents.
	*h = append(*h, x.(int))
}

func (h *IntHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func FurthestBuilding(heights []int, bricks int, ladders int) int {
	return furthestBuilding(heights, bricks, ladders)
}

func furthestBuilding(heights []int, bricks int, ladders int) int {
	h := &IntHeap{}
	heap.Init(h)

	n := len(heights)

	for i := 0; i < n-1; i++ {
		diff := heights[i+1] - heights[i]

		if diff <= 0 {
			continue
		}

		heap.Push(h, diff)

		if h.Len() <= ladders {
			continue
		}

		bricks -= heap.Pop(h).(int)

		if bricks < 0 {
			return i
		}
	}

	return n - 1
}
