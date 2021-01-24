class Solution {
    func searchInsert(_ nums: [Int], _ target: Int) -> Int {
        var index: Int = 0
        while index < nums.count {
            if nums[index] >= target {
                return index
            }
            index += 1
        }
        return index
    }
}