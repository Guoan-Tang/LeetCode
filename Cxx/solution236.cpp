#include <iostream>

class Solution {
   private:
    struct TreeNode {
        int val;
        TreeNode* left;
        TreeNode* right;
        TreeNode(int x) : val(x), left(NULL), right(NULL) {}
    };

    TreeNode* res = NULL;

    bool core(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == NULL) {
            return false;
        }
        bool l = core(root->left, p, q), r = core(root->right, p, q);
        if (((root->val == p->val || root->val == q->val) && (l || r)) ||
            (l && r)) {
            res = root;
        }
        return root->val == p->val || root->val == q->val || l || r;
    }

   public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        core(root, p, q);
        return res;
    }
};