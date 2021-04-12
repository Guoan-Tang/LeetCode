#include <iostream>
#include <vector>
using namespace std;

class Solution {
   public:
    string removeDuplicateLetters(string s) {
        vector<int> unJoin(26), hadJoin(26);
        string str;
        char c, t;
        for (int i = 0; i < s.length(); i++) {
            c = s[i];
            unJoin[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            c = s[i];
            if (hadJoin[c - 'a']) {
                unJoin[c - 'a']--;
                continue;
            }
            while (str.length() > 0 && str.back() > c) {
                t = str.back();
                if (unJoin[t - 'a']) {
                    hadJoin[t - 'a']--;
                    str.pop_back();
                } else {
                    break;
                }
            }
            str.push_back(c);
            hadJoin[c - 'a']++;
            unJoin[c - 'a']--;
        }
        return str;
    }
};