package LeetCode;

import java.util.LinkedList;

public class solution60 {
    public String getPermutation(int n, int k) {
        StringBuffer res = new StringBuffer();
        if (n == 1) {
            return res.append(n).toString();
        }
        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        int[] factorial = new int[n - 1];
        factorial[0] = 1;
        for (int i = 2; i <= n - 1; i++) {
            factorial[i - 1] = factorial[i - 2] * i;
        }

        k--;
        for (int i = 0; i < n - 1; i++) {
            int index = k / factorial[factorial.length - 1 - i];
            res.append(nums.get(index));
            nums.remove(index);
            k -= index * factorial[factorial.length - 1 - i];
        }
        res.append(nums.get(0));
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new solution60().getPermutation(3, 3));
    }
}
