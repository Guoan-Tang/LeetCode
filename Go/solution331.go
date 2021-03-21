package leetcode

func isValidSerialization(preorder string) bool {
	if len(preorder) < 1 {
		return false
	}
	preorders := split(preorder)
	stack := []int{}
	if preorders[0] {
		stack = append(stack, 2)
	}
	for i := 1; i < len(preorders); i++ {
		if len(stack) < 1 {
			return false
		}
		stack[len(stack)-1]--
		if stack[len(stack)-1] == 0 {
			stack = stack[:len(stack)-1]
		}
		if preorders[i] {
			stack = append(stack, 2)
		}
	}
	if len(stack) == 0 {
		return true
	}
	return false
}

func split(input string) []bool {
	var res []bool = []bool{}
	var temp byte
	for i := range input {
		if input[i] == ',' {
			if temp == '#' {
				res = append(res, false)
			} else {
				res = append(res, true)
			}
		} else {
			temp = input[i]
		}
	}
	if temp == '#' {
		res = append(res, false)
	} else {
		res = append(res, true)
	}
	return res
}
