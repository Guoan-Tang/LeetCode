package leetcode

func strToInt(str string) int {
	var cur int = 0
	var positive bool = true
	for cur < len(str) {
		if str[cur] == '-' {
			positive = false
			cur++
			break
		} else if str[cur] == '+' {
			cur++
			break
		} else if str[cur] == ' ' {
			cur++
			continue
		} else {
			break
		}
	}
	var (
		res int = 0
		c   byte
		max int = int(^uint32(0) >> 1)
		min int = -max - 1
	)
	for cur < len(str) {
		c = str[cur]
		if c >= '0' && c <= '9' {
			res += int(c - '0')
			if res >= 2147483648 {
				res *= 10
				break
			}
			res *= 10
			cur++
		} else {
			break
		}
	}
	res /= 10
	if !positive {
		res = -res
	}
	if res > max {
		res = max
	} else if res < min {
		res = min
	}
	return res
}
