#include <iostream>
using namespace std;

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

   public:
    int minDiffInBST(TreeNode *root) {
        int res = INT_MAX, pre = -1;
        dfs(root, pre, res);
        return res;
    }

    void dfs(TreeNode *root, int &pre, int &res) {
        if (root == nullptr) {
            return;
        }
        dfs(root->left, pre, res);
        if (pre != -1) {
            res = min(root->val - pre, res);
        }
        pre = root->val;
        dfs(root->right, pre, res);
    }
};