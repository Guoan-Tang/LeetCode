#include <iostream>
#include <vector>
using namespace std;

class Solution {
   public:
    vector<int> grayCode(int n) {
        vector<int> res = vector<int>();
        res.push_back(0);
        int head = 1;
        while (n > 0) {
            n--;
            for (int j = res.size() - 1; j >= 0; j--) {
                res.push_back(res[j] + head);
            }
            head <<= 1;
        }
        return res;
    }
};