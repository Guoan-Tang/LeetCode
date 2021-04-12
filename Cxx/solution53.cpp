#include <iostream>
#include <vector>
using namespace std;

class Solution {
   public:
    int maxSubArray(vector<int>& nums) {
        if (nums.size() < 1) {
            return 0;
        }
        int res = INT_MIN, dp = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (dp > 0) {
                dp = dp + nums[i];
            } else {
                dp = nums[i];
            }
            if (dp > res) {
                res = dp;
            }
        }
        return res;
    }
};