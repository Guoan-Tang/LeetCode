package leetcode

func twoSum(nums []int, target int) []int {
	hashTable := map[int]int{}
	for index, value := range nums {
		if targetIndex, have := hashTable[value]; have {
			return []int{index, targetIndex}
		} else {
			hashTable[target-value] = index
		}
	}
	return []int{}
}
