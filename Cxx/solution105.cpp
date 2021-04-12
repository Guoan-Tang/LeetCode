#include <iostream>
#include <vector>
using namespace std;

class solution {
    struct TreeNode {
        int val;
        TreeNode* left;
        TreeNode* right;
        TreeNode() : val(0), left(nullptr), right(nullptr) {}
        TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
        TreeNode(int x, TreeNode* left, TreeNode* right)
            : val(x), left(left), right(right) {}
    };

    TreeNode* core(vector<int>& preorder, vector<int>& inorder, int preL,
                   int preR, int inL, int inR) {
        if (preL > preR) {
            return nullptr;
        }
        int index = inL;
        while (index <= inR && inorder[index] != preorder[preL]) {
            index++;
        }
        if (index > inR) {
            return nullptr;
        }
        return new TreeNode(preorder[0], core(preorder, inorder, preL + 1, preL + index - inL, inL, index - 1), core(preorder, inorder, preL + 1 + index - inL, preR, index + 1, inR));
    }

   public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        return core(preorder, inorder, 0, preorder.size() - 1, 0, preorder.size() - 1);
    }
};