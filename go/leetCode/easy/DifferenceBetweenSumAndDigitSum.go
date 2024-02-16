package easy

import "math"

func differenceOfSum(nums []int) int {
	sum := 0
	digitSum := 0

	for _, v := range nums {
		sum += v
		digitSum += getDigitSum(v)
	}

	return int(math.Abs(float64(sum - digitSum)))
}

func getDigitSum(num int) int {
	result := 0
	for num > 0 {
		result += num % 10
		num /= 10
	}

	return result
}
