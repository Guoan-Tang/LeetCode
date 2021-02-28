package leetcode

func maxProfit(prices []int) int {
	if len(prices) < 1 {
		return 0
	}
	var min int = prices[0]
	var res int = 0
	for i := 1; i < len(prices); i++ {
		if prices[i]-min > res {
			res = prices[i] - min
		}
		if min > prices[i] {
			min = prices[i]
		}
	}
	return res
}
