package easy

func intersection(nums1 []int, nums2 []int) []int {
	set := make(map[int]bool, 0)

	for _, num := range nums1 {
		set[num] = false
	}

	result := make([]int, 0)

	for _, num := range nums2 {
		used, exists := set[num]

		if exists && !used {
			result = append(result, num)
			set[num] = true
		}
	}

	return result
}
