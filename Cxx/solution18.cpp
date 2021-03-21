#include <iostream>
#include <vector>
using namespace std;

class Solution {
   public:
    vector< vector<int> > fourSum(vector<int>& nums, int target) {
        vector< vector<int> > res;
        if (nums.size() < 4) {
            return res;
        }
        vector<int> temp;
        int left, right, sum;
        quickSort(nums, 0, nums.size() - 1);
        for (int i = 0; i < nums.size() - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.size() - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                left = j + 1;
                right = nums.size() - 1;
                while (left < right) {
                    sum = nums[i] + nums[j] + nums[left] + nums[right] - target;
                    if (sum == 0) {
                        temp.clear();
                        temp.push_back(nums[i]);
                        temp.push_back(nums[j]);
                        temp.push_back(nums[left]);
                        temp.push_back(nums[right]);
                        res.push_back(vector<int>(temp));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum > 0) {
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else {
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    }
                }
            }
        }
        return res;
    }

   private:
    void quickSort(vector<int>& nums, int left, int right) {
        if (left < right) {
            int mid = partition(nums, left, right);
            quickSort(nums, left, mid - 1);
            quickSort(nums, mid + 1, right);
        }
    }

    int partition(vector<int>& nums, int left, int right) {
        int pivot = nums[left], pivotPos = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= pivot) {
                pivotPos++;
                if (i != pivotPos) {
                    int temp = nums[i];
                    nums[i] = nums[pivotPos];
                    nums[pivotPos] = temp;
                }
            }
        }
        nums[left] = nums[pivotPos];
        nums[pivotPos] = pivot;
        return pivotPos;
    }
};