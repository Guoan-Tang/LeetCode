package leetcode

func lastRemaining(n int, m int) int {
	if n == 1 {
		return 0
	}
	return (m + lastRemaining(n-1, m)) % n
}
