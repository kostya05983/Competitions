package medium

func pivotInteger(n int) int {
	prefixSum := make([]int, n+2)

	sum := 0
	for i := 1; i <= n; i++ {
		sum += i
		prefixSum[i] = sum
	}

	for i := 1; i <= n; i++ {
		if prefixSum[i] == (sum - prefixSum[i-1]) {
			return i
		}
	}

	return -1
}
