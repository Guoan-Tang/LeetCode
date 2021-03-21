package leetcode

var rows, cols int
var index int
var res []int

func spiralOrder(matrix [][]int) []int {
	rows = len(matrix)
	cols = len(matrix[0])
	res = make([]int, rows*cols)
	index = 0
	for i := 0; i < (min(rows, cols)+1)/2; i++ {
		rotation(i, matrix)
	}
	return res
}

func rotation(n int, matrix [][]int) {
	for i := n; i < cols-n; i++ {
		res[index] = matrix[n][i]
		index++
	}
	for i := n + 1; i < rows-n; i++ {
		res[index] = matrix[i][cols-n-1]
		index++
	}
	if rows-n-1 > n {
		for i := cols - n - 2; i >= n; i-- {
			res[index] = matrix[rows-n-1][i]
			index++
		}
	}
	if cols-n-1 > n {
		for i := rows - n - 2; i > n; i-- {
			res[index] = matrix[i][n]
			index++
		}
	}
}

func min(x int, y int) int {
	if x < y {
		return x
	}
	return y
}
