package leetcode

func transpose(matrix [][]int) [][]int {
	n, m := len(matrix), len(matrix[0])
	res := make([][]int, m)
	// initialize the res arr
	for i := range res {
		res[i] = make([]int, n)
		for j := range res[i] {
			res[i][j] = -1
		}
	}
	for i, row := range matrix {
		for j, v := range row {
			res[j][i] = v
		}
	}
	return res
}
