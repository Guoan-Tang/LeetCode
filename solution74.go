package leetcode

func searchMatrix(matrix [][]int, target int) bool {
	var row, col int
	row = 0
	col = len(matrix) - 1
	for row < len(matrix[0]) && col >= 0 {
		if matrix[row][col] == target {
			return true
		} else if matrix[row][col] > target {
			col--
		} else {
			row++
		}
	}
	return false
}
