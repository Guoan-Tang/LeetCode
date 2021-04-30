#include <iostream>
#include <vector>
using namespace std;

class Solution {
	int res = 0;
  public:
  	int combinationSum4(vector<int>& nums, int target) {
  		vector<unsigned int> dp = vector<unsigned int>(target + 1);
        dp[0] = 1;
  		for (int i = 1; i <= target; i++) {
  			for (int num : nums) {
  				if (num <= i) {
  					dp[i] += dp[i - num];
  				}
  			}
  		}
  		return dp[target];
	}

  	// violence solve
	int combinationSum4_violence(vector<int>& nums, int target) {
		sort(nums.begin(), nums.end());
		recursive(nums, target);
		return res;
	}

	void recursive(vector<int>& nums, int target) {
		for (int num : nums) {
			if (num == target) {
				res++;
			} else if (num < target) {
				recursive(nums, target - num);
			} else {
				break;
			}
		}
	}
};