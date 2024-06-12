package sort_colors

func sortColors(nums []int) {
	countArr := make([]int, 3)

	for _, num := range nums {
		countArr[num]++
	}

	i := 0
	j := 0
	for i < len(nums) {
		if countArr[j] == 0 {
			j++
			continue
		}
		nums[i] = j
		countArr[j]--
		i++
	}

	return
}
