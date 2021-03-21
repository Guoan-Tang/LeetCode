package leetcode

import (
	"sort"
)

func maxEnvelopes(envelopes [][]int) int {
	var n int = len(envelopes)
	if n < 1 {
		return 0
	}
	sort.Slice(envelopes, func(i, j int) bool {
		a, b := envelopes[i], envelopes[j]
		if a[0] < b[0] {
			return true
		} else if a[0] == b[0] {
			return a[1] >= b[1]
		}
		return false
	})
	dp := make([]int, n)
	dp[0] = 1
	res := 1
	for i := 1; i < n; i++ {
		maxLen := 0
		for j := i - 1; j >= maxLen; j-- {
			if envelopes[j][1] < envelopes[i][1] && dp[j] > maxLen {
				maxLen = dp[j]
			}
		}
		dp[i] = maxLen + 1
		if dp[i] > res {
			res = dp[i]
		}
	}
	return res
}
