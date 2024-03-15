package medium

func productExceptSelf(nums []int) []int {
	product := 1
	zeroCount := 0

	for _, num := range nums {
		if num == 0 {
			zeroCount++
			continue
		}
		product *= num
	}

	result := make([]int, len(nums))

	for i := 0; i < len(nums); i++ {
		num := nums[i]

		if num == 0 {
			if zeroCount == 1 {
				result[i] = product
			} else {
				result[i] = 0
			}
		} else {
			if zeroCount > 0 {
				result[i] = 0
			} else {
				result[i] = product / nums[i]
			}
		}
	}

	return result
}
