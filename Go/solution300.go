package leetcode

func lengthOfLIS(nums []int) int {
	if len(nums) < 1 {
		return 0
	}
	var dp []int = make([]int, len(nums))
	dp[0] = 1
	var res int = 1
	for i := 1; i < len(nums); i++ {
		maxLen := 0
		for j := i - 1; j >= maxLen; j-- {
			if nums[j] < nums[i] && dp[j] > maxLen {
				maxLen = dp[j]
			}
		}
		dp[i] = maxLen + 1
		if dp[i] > res {
			res = dp[i]
		}
	}
	return res
}
