package leetcode

var res [][]int

type dir struct {
	x, y int
}

func generateMatrix(n int) [][]int {
	var col, row, dirIndex int = -1, 0, 0
	var dir [][]int = [][]int{
		{1, 0},
		{0, 1},
		{-1, 0},
		{0, -1},
	}
	res = make([][]int, n)
	for i := range res {
		res[i] = make([]int, n)
	}
	for i := 0; i < n*n; i++ {
		if col+dir[dirIndex][0] >= n || row+dir[dirIndex][1] >= n || col+dir[dirIndex][0] < 0 || row+dir[dirIndex][1] < 0 || res[row+dir[dirIndex][1]][col+dir[dirIndex][0]] != 0 {
			dirIndex = (dirIndex + 1) % 4
		}
		col += dir[dirIndex][0]
		row += dir[dirIndex][1]
		res[row][col] = i + 1
	}
	return res
}
