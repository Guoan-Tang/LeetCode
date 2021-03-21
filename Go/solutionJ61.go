package leetcode

func isStraight(nums []int) bool {
	var count []int = make([]int, 14)
	var min int = int(^uint(0) >> 1)
	var max int = -min - 1
	for i := 0; i < len(nums); i++ {
		if nums[i] == 0 {
			count[nums[i]]++
		} else {
			if count[nums[i]] != 0 {
				return false
			} else {
				count[nums[i]]++
				if nums[i] > max {
					max = nums[i]
				}
				if nums[i] < min {
					min = nums[i]
				}
			}
		}
	}
	if max-min <= 4 {
		return true
	}
	return false
}
