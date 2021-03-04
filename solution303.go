package leetcode

type NumArray struct {
	nums []int
}

func Constructor(nums []int) NumArray {
	res := NumArray{nums: nil}
	if len(nums) < 1 {
		return res
	}
	res.nums = make([]int, len(nums))
	res.nums[0] = nums[0]
	for i := 1; i < len(nums); i++ {
		res.nums[i] = res.nums[i-1] + nums[i]
	}
	return res
}

func (this *NumArray) SumRange(i int, j int) int {
	if i < 1 {
		return this.nums[j]
	} else {
		return this.nums[j] - this.nums[i-1]
	}
}
