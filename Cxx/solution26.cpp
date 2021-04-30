#include <iostream>
using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
    	int res = 0, cur = 0;
    	while (cur < nums.size()) {
    		if (res > 0 && nums[res - 1] == nums[cur]) {
    			cur++;
    		} else {
    			nums[res++] = nums[cur++];
    		}
    	}
    	return res;
    }
};