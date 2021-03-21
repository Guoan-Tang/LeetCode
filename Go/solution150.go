package leetcode

func evalRPN(tokens []string) int {
	intStack := []int{}
	for i := range tokens {
		var token string = tokens[i]
		if token == "+" || token == "-" || token == "*" || token == "/" {
			if token == "+" {
				intStack[len(intStack)-2] += intStack[len(intStack)-1]
				intStack = intStack[:len(intStack)-2]
			} else if token == "-" {
				intStack[len(intStack)-2] -= intStack[len(intStack)-1]
				intStack = intStack[:len(intStack)-2]
			} else if token == "*" {
				intStack[len(intStack)-2] *= intStack[len(intStack)-1]
				intStack = intStack[:len(intStack)-2]
			} else {
				intStack[len(intStack)-2] /= intStack[len(intStack)-1]
				intStack = intStack[:len(intStack)-2]
			}
		} else {
			intStack = append(intStack, stoi(token))
		}
	}
	return intStack[0]
}

func stoi(token string) int {
	i := 0
	if token[i] == '+' || token[i] == '-' {
		i++
	}
	res := 0
	for i < len(token) {
		res = res*10 + int(token[i]) - '0'
	}
	if token[0] == '-' {
		res = -res
	}
	return res
}
