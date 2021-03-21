package leetcode

func calculate(s string) int {
	n := len(s)
	var preSign byte
	preSign = '+'
	stack := []int{}
	num := 0
	for i := 0; i < n; i++ {
		if isDigital(s[i]) {
			num = num*10 + int(s[i]-'0')
		}
		if (!isDigital(s[i]) && s[i] != ' ') || i == n-1 {
			switch preSign {
			case '+':
				stack = append(stack, num)
			case '-':
				stack = append(stack, -num)
			case '*':
				num *= stack[len(stack)-1]
				stack = append(stack[:len(stack)-1], num)
			case '/':
				stack[len(stack)-1] /= num
			}
			num = 0
			preSign = s[i]
		}
	}
	for i := range stack {
		num += stack[i]
	}
	return num
}

func isDigital(c byte) bool {
	if c >= '0' && c <= '9' {
		return true
	}
	return false
}
