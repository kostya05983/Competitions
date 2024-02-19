package easy

func diagonalPrime(nums [][]int) int {
	result := 0

	n := len(nums)

	for i := 0; i < n; i++ {

		if isPrime(nums[i][i]) {
			result = max(result, nums[i][i])
		}
		if isPrime(nums[i][n-i-1]) {
			result = max(result, nums[i][n-i-1])
		}
	}

	return result
}

var primeNums = make(map[int]bool)

func isPrime(num int) bool {
	_, ok := primeNums[num]
	if ok {
		return true
	}

	if num <= 2 || num%2 == 0 {
		return num == 2
	}

	for i := 3; i*i <= num; i = i + 2 {
		if num%i == 0 {
			return false
		}
	}

	primeNums[num] = true

	return true
}
