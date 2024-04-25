package longest_ideal_subsequence

import (
	"math"
)

func LongestIdealString(s string, k int) int {
	dp := make([][]int, len(s))
	for i := range dp {
		dp[i] = make([]int, 26)
		for j := range dp[i] {
			dp[i][j] = -1
		}
	}

	result := 0
	for c := 0; c < 26; c++ {
		result = max(result, dfs(len(s)-1, c, dp, s, k))
	}

	return result
}

func dfs(i int, ch int, dp [][]int, s string, k int) int {
	memorized := dp[i][ch]
	if memorized != -1 {
		return memorized
	}

	dp[i][ch] = 0
	current := int(s[i] - 'a')

	if current == ch {
		dp[i][ch] = 1
	}

	if i > 0 {
		dp[i][ch] = dfs(i-1, ch, dp, s, k)
		if current == ch {
			for p := 0; p < 26; p++ {
				if int(math.Abs(float64(ch-p))) <= k {
					dp[i][ch] = max(dp[i][ch], dfs(i-1, p, dp, s, k)+1)
				}
			}
		}
	}

	return dp[i][ch]
}
