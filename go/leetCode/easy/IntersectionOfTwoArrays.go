package easy

func intersection(nums1 []int, nums2 []int) []int {
	set := make(map[int]bool, 0)

	for _, num := range nums1 {
		set[num] = true
	}

	intersectedNums := make(map[int]bool, 0)

	for _, num := range nums2 {
		if set[num] {
			intersectedNums[num] = true
		}
	}

	result := make([]int, 0)

	for key, _ := range intersectedNums {
		result = append(result, key)
	}

	return result
}
