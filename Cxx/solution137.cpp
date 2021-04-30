#include <vector>
#include <iostream>
using namespace std;

class Solution {
   public:
    int singleNumber(vector<int>& nums) {
        int res = 0, count;
        for (int i = 0; i < 32; i++) {
            count = 0;
            for (int num : nums) {
                count += ((num >> i) & 1);
            }
            if (count % 3 != 0) {
                res |= (1 << i);
            }
        }
        return res;
    }
};