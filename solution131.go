package leetcode

func partition(s string) [][]string {
	ans := [][]string{}
	n := len(s)
	// build a table to learn if s[i:j] is a palindromic substring by dynamic programming
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
	temp := []string{}
	// get anser by traceBack
	var dfs func(int)
	dfs = func(i int) {
		if i == n {
			// current temp satisfies the answer requirement
			ans = append(ans, append([]string{}, temp...))
			return
		}
		for j := i; j < n; j++ {
			if dp[i][j] {
				temp = append(temp, s[i:j+1])
				dfs(j + 1)
				// after the lower function has finished, remove the subString you just adding to the temp in order to find another subString which is start from s[i]
				temp = temp[:len(temp)-1]
			}
		}
	}
	dfs(0)
	return ans
}
