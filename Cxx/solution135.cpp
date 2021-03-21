#include <vector>
using namespace std;

int candy(vector<int>& ratings) {
    vector<int> left(ratings.size(), 1);
    for (int i = 1; i < ratings.size(); i++) {
        if (ratings[i] > ratings[i - 1]) {
            left[i] = left[i - 1] + 1;
        }
    }
    int res = left[ratings.size() - 1], tempCandy = left[ratings.size() - 1];
    for (int i = ratings.size() - 2; i >= 0; i--) {
        if (ratings[i] > ratings[i + 1]) {
            tempCandy = (tempCandy + 1) > left[i] ? (tempCandy + 1) : left[i];
        } else {
            tempCandy = left[i];
        }
        res += tempCandy;
    }
    return res;
}