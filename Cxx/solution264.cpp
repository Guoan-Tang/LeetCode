#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
   public:
    int nthUglyNumber(int n) {
        int *dp = new int[n], a = 0, b = 0, c = 0, d = 1;
        dp[0] = 1;
        while (d < n) {
            int resA = dp[a] * 2, resB = dp[b] * 3, resC = dp[c] * 5;
            dp[d] = min(min(resA, resB), resC);
            if (dp[d] == resA) {
                a++;
            }
            if (dp[d] == resB) {
                b++;
            }
            if (dp[d] == resC) {
                c++;
            }
            d++;
        }
        return dp[d - 1];
    }
};