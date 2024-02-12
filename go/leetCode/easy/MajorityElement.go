package easy

func majorityElement(nums []int) int {
	n := len(nums)
	frequencies := make(map[int]int)

	result := 0
	for _, num := range nums {
		frequencies[num] = frequencies[num] + 1
		if frequencies[num] > n/2 {
			result = num
		}
	}

	return result
}
