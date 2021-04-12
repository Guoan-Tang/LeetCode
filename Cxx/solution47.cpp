#include <iostream>
#include <vector>
using namespace std;

class Solution {
    vector<bool> used;

    void recursive(int index, vector<int>& nums, vector<int>& temp,
                   vector<vector<int> >& res) {
        if (index == used.size()) {
            res.__emplace_back(temp);
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            temp.push_back(nums[i]);
            recursive(index + 1, nums, temp, res);
            temp.pop_back();
            used[i] = false;
        }
    }

   public:
    vector<vector<int> > permuteUnique(vector<int>& nums) {
        used.resize(nums.size());
        sort(nums.begin(), nums.end());
        vector<vector<int> > res;
        vector<int> temp;
        recursive(0, nums, temp, res);
        return res;
    }
};