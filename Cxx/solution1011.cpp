class Solution {
public:
    int shipWithinDays(vector<int>& weights, int D) {
        int l = 0, r = 0, mid;
        for (int num : weights) {
            r += num;
            l = max(num, l);
        }
        mid = (l + r) / 2;
        while (l != r && l != r - 1) {
            if (judge(weights, D, mid)) {
                r = mid;
            } else {
                l = mid;
            }
            mid = (l + r) / 2;
        }
        if (judge(weights, D, l)) {
            return l;
        }
        return r;
    }

    bool judge(vector<int>& weights, int D, int capacity) {
        int cur = capacity, day = 1;
        for (int num : weights) {
            if (cur >= num) {
                cur -= num;
            } else {
                day++;
                cur = capacity - num;
            }
        }
        return day <= D;
    }
};