package leetcode

func constructArr(a []int) []int {
	if len(a) < 1 {
		return make([]int, 0)
	}
	var b []int = make([]int, len(a))
	b[0] = 1
	for i := 1; i < len(b); i++ {
		b[i] = b[i-1] * a[i-1]
	}
	var temp int = 1
	for i := len(a) - 2; i >= 0; i-- {
		temp = temp * a[i+1]
		b[i] *= temp
	}
	return b
}
