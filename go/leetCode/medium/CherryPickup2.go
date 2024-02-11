package medium

func cherryPickup(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])

	var dp = make([][][]int, m)
	for i := range dp {
		dp[i] = make([][]int, n)
		for j := range dp[i] {
			dp[i][j] = make([]int, n)
		}
	}

	for i := m - 1; i >= 0; i-- {
		for j := range dp[i] {
			for k := range dp[i] {
				result := 0
				result += grid[i][j]
				if j != k {
					result += grid[i][k]
				}

				if i != m-1 {
					maxRes := 0
					for newJ := j - 1; newJ <= j+1; newJ++ {
						for newK := k - 1; newK <= k+1; newK++ {
							if newJ >= 0 && newJ < n && newK >= 0 && newK<n {
								maxRes = max(maxRes, dp[i+1][newJ][newK])
							}
						}
					}
					result += maxRes
				}
				dp[i][j][k] = result
			}
		}
	}

	return dp[0][0][m-1]
}
