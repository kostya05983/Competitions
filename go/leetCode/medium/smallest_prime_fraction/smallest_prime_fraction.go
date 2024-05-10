package smallest_prime_fraction

import (
	"container/heap"
	"sort"
)

type Element struct {
	left  int
	right int
	diff  float64
}

type MinHeap []*Element

func (h MinHeap) Len() int           { return len(h) }
func (h MinHeap) Less(i, j int) bool { return h[i].diff < h[j].diff }
func (h MinHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *MinHeap) Push(x any) {
	// Push and Pop use pointer receivers because they modify the slice's length,
	// not just its contents.
	*h = append(*h, x.(*Element))
}

func (h *MinHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func kthSmallestPrimeFraction(arr []int, k int) []int {
	sort.Ints(arr)

	right := len(arr) - 1

	minHeap := make(MinHeap, 0)

	for right >= 1 {
		element := Element{
			0,
			right,
			float64(arr[0]) / float64(arr[right]),
		}
		minHeap = append(minHeap, &element)
		right--
	}

	heap.Init(&minHeap)

	for k > 1 {
		popped := heap.Pop(&minHeap).(*Element)
		newLeft := popped.left + 1
		heap.Push(&minHeap, &Element{left: newLeft, right: popped.right, diff: float64(arr[newLeft]) / float64(arr[popped.right])})
		k--
	}

	last := heap.Pop(&minHeap).(*Element)

	return []int{arr[last.left], arr[last.right]}
}
