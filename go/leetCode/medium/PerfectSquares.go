package medium

import (
	"math"
)

func numSquares(n int) int {
	var dp = make([]int, n+1)

	for i := range dp {
		dp[i] = math.MaxInt
	}

	dp[0] = 0

	var maxSquareIndex = int(math.Sqrt(float64(n)) + 1)
	var squareNums = make([]int, maxSquareIndex)

	for i := 1; i < maxSquareIndex; i++ {
		squareNums[i] = i * i
	}

	for i := 1; i <= n; i++ {
		for s := 1; s < maxSquareIndex; s++ {
			if i < squareNums[s] {
				break
			}

			dp[i] = min(dp[i], dp[i-squareNums[s]]+1)
		}
	}

	return dp[n]
}
