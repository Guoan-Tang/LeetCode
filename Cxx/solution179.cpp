#include <algorithm>
#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
   public:
    string largestNumber(vector<int>& nums) {
        sort(nums.begin(), nums.end(), [](const int& n1, const int& n2) {
            long sn1 = 10, sn2 = 10;
            while (sn1 <= n1) {
                sn1 *= 10;
            }
            while (sn2 <= n2) {
                sn2 *= 10;
            }
            return sn1 * n2 + n1 < sn2 * n1 + n2;
        });
        if (nums[0] == 0) {
            return "0";
        }
        string res;
        for (int& i : nums) {
            res += to_string(i);
        }
        return res;
    }
};