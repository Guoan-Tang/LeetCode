

import java.util.*;

public class solution1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        List<item> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(i, new item(nums[i], i));
        }
        Collections.sort(list);
        item temp;
        int index;
        for (int i = 0; i < nums.length; i++) {
            temp = list.get(i);
            index = i - 1;
            while (index > 0 && list.get(index).val == temp.val) {
                index--;
            }
            if (index >= 0 && list.get(index).val != temp.val) {
                res[temp.index] = index + 1;
            }
        }
        return res;
    }

    class item implements Comparable<item> {
        int val;
        int index;

        public item(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(item target) {
            return val - target.val;
        }
    }

    public static void main(String[] args) {
        // int[] input = { 8, 1, 2, 2, 3 };
        // int[] test = new solution1365().smallerNumbersThanCurrent(input);
    }
}