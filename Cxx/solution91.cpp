#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int numDecodings(string s) {
    	if (s.length() < 1) {
    		return 0;
    	}
    	if (s.length() < 2) {
    		return s[0] == '0' ? 0 : 1;
    	}
    	vector<int> dp = vector<int>(s.length());
    	if (s[0] == '0') {
    		return 0;
    	} else {
    		dp[0] = 1;
    	}
    	if (s[1] == '0') {
    		if (s[0] == '1' || s[0] == '2') {
    			dp[1] = 1;
    		} else {
    			dp[1] = 0;
    		}
    	} else if (s[1] >= '1' && s[1] <= '6') {
		    if (s[0] == '1' || s[0] == '2') {
				dp[1] = 2;
			} else {
				dp[1] = 1;
			}
    	} else {
		    if (s[0] == '1') {
				dp[1] = 2;
			} else {
				dp[1] = 1;
			}
    	}
    	for (int i = 2; i < s.length(); i++) {
    		if (s[i] == '0') {
    			if (s[i - 1] == '1' || s[i - 1] == '2') {
    				dp[i] = dp[i - 2];
    			} else {
    				dp[i] = 0;
    			}
    		} else if (s[i] >= '1' && s[i] <= '6') {
    			if (s[i - 1] == '1' || s[i - 1] == '2') {
    				dp[i] = dp[i - 1] + dp[i - 2];
    			} else {
    				dp[i] = dp[i - 1];
    			}
    		} else {
    			if (s[i - 1] == '1') {
    				dp[i] = dp[i - 1] + dp[i - 2];
    			} else {
    				dp[i] = dp[i - 1];
    			}
    		}
    	}
    	return dp[dp.size() - 1];
    }
};