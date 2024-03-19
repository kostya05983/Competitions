package medium

import "container/heap"

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
	frequency := make(map[byte]int, 0)

	for _, task := range tasks {
		frequency[task]++
	}

	maxHeap := &MaxHeap{}

	for _, value := range frequency {
		if value > 0 {
			maxHeap.Push(value)
		}
	}
	heap.Init(maxHeap)

	time := 0

	for maxHeap.Len() > 0 {
		cycle := n + 1
		list := make([]int, 0)
		count := 0

		for cycle > 0 && maxHeap.Len() > 0 {
			cycle--
			popped := heap.Pop(maxHeap).(int)
			if popped > 1 {
				list = append(list, popped-1)
			}
			count++
		}

		for _, value := range list {
			heap.Push(maxHeap, value)
		}

		if maxHeap.Len() == 0 {
			time += count
		} else {
			time += n + 1
		}
	}

	return time
}
