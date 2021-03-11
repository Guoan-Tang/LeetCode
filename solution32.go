package leetcode

func minCut(s string) int {
	n := len(s)
	dp := make([][]bool, n)
	for i := range dp {
		dp[i] = make([]bool, n)
		for j := range dp[i] {
			dp[i][j] = true
		}
	}
	for i := n - 1; i >= 0; i-- {
		for j := i + 1; j < n; j++ {
			if s[i] != s[j] || !dp[i+1][j-1] {
				dp[i][j] = false
			}
		}
	}
	res := make([]int, n)
	res[0] = 0
	for i := 1; i < n; i++ {
		if dp[0][i] {
			continue
		}
		res[i] = i
		for j := 0; j < i; j++ {
			if dp[j+1][i] && res[j]+1 < res[i] {
				res[i] = res[j] + 1
			}
		}
	}
	return res[n-1]
}
