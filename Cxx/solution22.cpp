#include <iostream>
#include <vector>
using namespace std;

class Solution {
    vector<string> res = vector<string>();
    int length;

    void dfs(char *content, int startIndex, int leftCount, int rightCount) {
        if (leftCount == 0 && rightCount == 0) {
            res.push_back(string(content, length));
            return;
        }
        if (leftCount == rightCount) {
            content[startIndex] = '(';
            dfs(content, startIndex + 1, leftCount - 1, rightCount);
        } else {
            if (leftCount > 0) {
                content[startIndex] = '(';
                dfs(content, startIndex + 1, leftCount - 1, rightCount);
            }
            content[startIndex] = ')';
            dfs(content, startIndex + 1, leftCount, rightCount - 1);
        }
    }

   public:
    vector<string> generateParenthesis(int n) {
        if (n <= 0) {
            return res;
        }
        length = 2 * n;
        char *content = new char[length];
        dfs(content, 0, n, n);
        return res;
    }
};