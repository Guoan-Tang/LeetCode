package leetcode

import (
	"fmt"
	"math"
)

func dicesProbability(n int) []float64 {
	dp := make([][]int, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]int, 6*n)
	}
	for i := 0; i < 6; i++ {
		dp[0][i] = 1
	}
	for i := 1; i < n; i++ {
		for j := i; j < 6*(i+1); j++ {
			for k := 1; k < 7; k++ {
				if j-k >= 0 {
					dp[i][j] += dp[i-1][j-k]
				}
			}
		}
	}
	var sum = math.Pow(float64(6), float64(n))
	fmt.Print(sum)
	res := make([]float64, 5*n+1)
	for i := 0; i < 5*n+1; i++ {
		res[i] = float64(dp[n-1][n+i-1]) / sum
	}
	return res
}
