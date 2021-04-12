#include <iostream>

class Solution {
    struct TreeNode {
        int val;
        TreeNode *left;
        TreeNode *right;
        TreeNode() : val(0), left(nullptr), right(nullptr) {}
        TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
        TreeNode(int x, TreeNode *left, TreeNode *right)
            : val(x), left(left), right(right) {}
    };

    int res = INT_MIN;

    int dfs(TreeNode *root) {
        if (root == NULL) {
            return 0;
        }
        int lValue = dfs(root->left), rValue = dfs(root->right), temp = root->val, temp0 = root->val;
        if (lValue > 0) {
            temp0 += lValue;
        }
        if (rValue > 0) {
            temp0 += rValue;
        }
        res = std::max(temp0, res);
        if (std::max(lValue, rValue) > 0) {
            temp += std::max(lValue, rValue);
        }
        return temp;
    }

   public:
    int maxPathSum(TreeNode *root) {
        dfs(root);
        return res;
    }
};