package hard

import (
	"container/heap"
)

type TreeKey struct {
	key       int
	frequency *int
}

type MinTreeKeyHeap []TreeKey

func (h MinTreeKeyHeap) Len() int { return len(h) }
func (h MinTreeKeyHeap) Less(i, j int) bool {
	return h[i].key < h[j].key
}
func (h MinTreeKeyHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *MinTreeKeyHeap) Push(x any) {
	*h = append(*h, x.(TreeKey))
}

func (h *MinTreeKeyHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

type MaxTreeKeyHeap struct {
	MinTreeKeyHeap
}

func (h MaxTreeKeyHeap) Less(i, j int) bool {
	return h.MinTreeKeyHeap[i].key > h.MinTreeKeyHeap[j].key
}

func countSubarrays(nums []int, minK int, maxK int) int64 {
	minHeap := &MinTreeKeyHeap{}
	heap.Init(minHeap)
	maxHeap := &MaxTreeKeyHeap{}
	heap.Init(maxHeap)

	frequencyMap := make(map[int]*TreeKey, 0)

	left := 0
	right := 0

	var result int64 = 0

	for ; right < len(nums); right++ {
		num := nums[right]

		if num < minK || num > maxK {
			right++
			left = right
			minHeap = &MinTreeKeyHeap{}
			heap.Init(minHeap)
			maxHeap = &MaxTreeKeyHeap{}
			heap.Init(maxHeap)
			frequencyMap = make(map[int]*TreeKey, 0)
			continue
		}

		value, ok := frequencyMap[num]
		if !ok {
			frequency := 1
			value = &TreeKey{num, &frequency}
			heap.Push(minHeap, *value)
			heap.Push(maxHeap, *value)
			frequencyMap[num] = value
		} else {
			*(value.frequency)++
		}

		minNum := getNumAndRemoveZeroMin(minHeap)
		maxNum := getNumAndRemoveZeroMax(maxHeap)

		if minNum == minK && maxNum == maxK {
			nextMinMaxIndex := int64(nextMinMax(right, nums, minNum, maxNum))

			for minNum == minK && maxNum == maxK {
				result += nextMinMaxIndex - int64(right)

				leftNum := nums[left]

				value, ok := frequencyMap[leftNum]
				if !ok {
					continue
				}
				*value.frequency--

				if *value.frequency == 0 {
					delete(frequencyMap, value.key)
				}
				left++

				if *value.frequency == 0 && (leftNum == minNum || leftNum == maxNum) {
					break
				}
			}
		}
	}

	return result
}

func getNumAndRemoveZeroMin(h *MinTreeKeyHeap) int {
	minNum := heap.Pop(h).(TreeKey)

	for *minNum.frequency == 0 && h.Len() > 0 {
		minNum = heap.Pop(h).(TreeKey)
	}

	heap.Push(h, minNum)
	return minNum.key
}

func getNumAndRemoveZeroMax(h *MaxTreeKeyHeap) int {
	minNum := heap.Pop(h).(TreeKey)

	for *minNum.frequency == 0 && h.Len() > 0 {
		minNum = heap.Pop(h).(TreeKey)
	}

	heap.Push(h, minNum)
	return minNum.key
}

func nextMinMax(right int, nums []int, minNum, maxNum int) int {
	for ; right < len(nums); right++ {
		num := nums[right]

		if num < minNum {
			return right
		}
		if num > maxNum {
			return right
		}
	}

	return len(nums)
}
