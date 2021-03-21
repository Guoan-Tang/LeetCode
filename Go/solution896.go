package leetcode

func isMonotonic(A []int) bool {
	if len(A) < 2 {
		return true
	}
	var increase bool = false
	var index int = 1
	for index < len(A) && A[index] == A[index-1] {
		index++
	}
	if index == len(A) {
		return true
	}
	if A[index] > A[index-1] {
		increase = true
	}
	for index < len(A) {
		if increase {
			if A[index] < A[index-1] {
				return false
			}
		} else {
			if A[index] > A[index-1] {
				return false
			}
		}
		index++
	}
	return true
}
