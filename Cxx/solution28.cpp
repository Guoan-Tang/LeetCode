#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int strStr(string haystack, string needle) {
    	if (needle.size() == 0) {
    		return 0;
    	}
    	vector<int> f = preBuild(needle);
    	for (int i = 0, j = 0; i < haystack.size(); i++) {
    		while (j > 0 && haystack[i] != needle[j]) {
    			j = f[j - 1];
    		}
    		if (haystack[i] == needle[j]) {
    			j++;
    		}
    		if (j == needle.size()) {
    			return i - j + 1;
    		}
    	}
    	return -1;
    }

    vector<int> preBuild(string	input) {
    	vector<int> res = vector<int>(input.size(), 0);
    	for (int i = 1, j = 0; i < res.size(); i++) {
    		while (j > 0 && input[j] != input[i]) {
    			j = res[j - 1];
    		}
    		if (input[j] == input[i]) {
    			j++;
    		}
    		res[i] = j;
    	}
    	return res;
    }
};