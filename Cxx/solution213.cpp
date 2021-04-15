#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 1) {
            return nums[0];
        }
        int dp0 = nums[0], dp1 = nums[0] > nums[1] ? nums[0] : nums[1], temp, res;
        for (int i = 2; i < nums.size() - 1; i++) {
            temp = max(dp0 + nums[i], dp1);
            dp0 = dp1;
            dp1 = temp;
        }
        if (nums.size() < 3) {
            return dp1;
        }
        res = dp1;
        dp0 = nums[1], dp1 = nums[1] > nums[2] ? nums[1] : nums[2];
        for (int i = 3; i < nums.size(); i++) {
            temp = max(dp0 + nums[i], dp1);
            dp0 = dp1;
            dp1 = temp;
        }
        return res > dp1 ? res : dp1;
    }
};