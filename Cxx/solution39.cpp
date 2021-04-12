#include <vector>
using namespace std;

class Solution {
    void dfs(vector<int> &candidates, vector<int> &temp, int index, int target,
             vector<vector<int> > &res) {
        if (index == candidates.size()) {
            return;
        }
        if (target == 0) {
            res.push_back(temp);
            return;
        }
        if (target - candidates[index] >= 0) {
            temp.push_back(candidates[index]);
            dfs(candidates, temp, index, target - candidates[index], res);
            temp.pop_back();
        }
        dfs(candidates, temp, index + 1, target, res);
    }

   public:
    vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
        vector<vector<int> > res;
        vector<int> temp;
        dfs(candidates, temp, 0, target, res);
        return res;
    }
};