#include <iostream>
using namespace std;

class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
    	int res = 0, cur = 0;
    	while (cur < nums.size()) {
    		if (nums[cur] != val) {
    			nums[res++] = nums[cur];
    		}
    		cur++;
    	}
    	return res;
    }
};