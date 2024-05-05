package count_pairs_in_two_arrays

import "sort"

func countPairs(nums1 []int, nums2 []int) int64 {
	diff := make([]int, len(nums1))

	for i := range nums1 {
		diff[i] = nums1[i] - nums2[i]
	}

	sort.Ints(diff)

	left := 0
	right := len(diff) - 1

	var result int64 = 0
	for left < right {
		if diff[left]+diff[right] > 0 {
			result = result + int64(right-left)
			right--
		} else {
			left++
		}
	}

	return result
}
