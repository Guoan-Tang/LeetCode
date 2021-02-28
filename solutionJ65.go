package leetcode

func add(a int, b int) int {
	for b != 0 {
		var c int = (a & b) << 1
		a ^= b
		b = c
	}
	return a
}
