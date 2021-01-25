package LeetCode;

import java.util.*;

public class solution69 {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int res = x >> 1, min = 0, max = x;
        while (true) {
            if (res * res == x) {
                return res;
            } else if ((long) res * res > x) {
                if ((long) (res - 1) * (res - 1) < x) {
                    return res - 1;
                }
                max = res;
                res = (res + min) / 2;
            } else {
                if ((long) (res + 1) * (res + 1) > x) {
                    return res;
                }
                min = res;
                res = (res + max) / 2;
            }
        }
    }

    public static void main(String[] args) {
        Properties props = System.getProperties();
        System.out.println("Java的执行环境版本号：" + props.getProperty("java.version"));
    }
}