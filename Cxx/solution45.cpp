#include <iostream>
using namespace std;

class Solution {
   public:
    int jump(vector<int>& nums) {
        if (nums.size() < 3) {
            return nums.size() - 1;
        }
        int curIndex;
        vector<int> dp = vector<int>(nums.size(), INT_MAX - 1);
        for (int i = 1; i < nums.size(); i++) {
            curIndex = nums.size() - 1 - i;
            if (nums[curIndex] >= i) {
                dp[curIndex] = 1;
            } else {
                for (int j = 1; j <= nums[curIndex]; j++) {
                    if (curIndex + j >= nums.size()) {
                        break;
                    }
                    dp[curIndex] = dp[curIndex] > dp[curIndex + j] ? dp[curIndex + j] : dp[curIndex];
                }
                dp[curIndex]++;
            }
        }
        return dp[0];
    }
};