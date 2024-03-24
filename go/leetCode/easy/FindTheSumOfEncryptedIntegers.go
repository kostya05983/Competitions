package easy

func sumOfEncryptedInt(nums []int) int {
	sum := 0

	for _, v := range nums {
		sum += sumOfMaxDigit(v)
	}

	return sum
}

func sumOfMaxDigit(num int) int {
	count := 0
	maxNum := 0
	for num > 0 {
		count++
		maxNum = max(maxNum, num%10)
		num = num / 10
	}

	result := 0
	for count > 0 {
		result = result*10 + maxNum
		count--
	}

	return result
}
