#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    string removeDuplicateLetters(string s) {
        vector<int> unJoin(26), hadJoin(26);
        for (char c : s) {
            unJoin[c - 'a']++;
        }
        string stk;
        for (char c : s) {
            if (!hadJoin[c - 'a']) {
                while (!stk.empty() && c < stk.back()) {
                    if (unJoin[stk.back() - 'a'] > 0) {
                        hadJoin[stk.back() - 'a'] = 0;
                        stk.pop_back();
                    } else {
                        break;
                    }
                }
                stk.push_back(c);
                hadJoin[c - 'a'] = 1;
            }
            unJoin[c - 'a']--;
        }
        return stk;
    }
};