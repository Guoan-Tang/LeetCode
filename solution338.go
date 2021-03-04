package leetcode

func countBits(num int) []int {
	var flag int = 0
	var res []int = make([]int, num+1)
	for i := 1; i <= num; i++ {
		if i&(i-1) == 0 {
			flag = i
			res[i] = 1
		} else {
			res[i] = res[i-flag] + 1
		}
	}
	return res
}
