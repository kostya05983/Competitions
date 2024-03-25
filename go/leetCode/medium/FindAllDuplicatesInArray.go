package medium

import "math"

func findDuplicates(nums []int) []int {
	result := make([]int, 0)

	for _, v := range nums {
		absValue := int(math.Abs(float64(v)))
		index := absValue - 1
		if nums[index] < 0 {
			result = append(result, absValue)
		}

		nums[index] *= -1
	}

	return result
}
