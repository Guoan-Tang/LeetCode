

import java.util.*;

public class solution5521 {
    public int maxProductPath(int[][] grid) {
        ArrayList<ArrayList<HashSet<Long>>> dp = new ArrayList<>(grid.length);
        for (int i = 0; i < grid.length; i++) {
            dp.add(new ArrayList<>(grid[0].length));
        }
        HashSet<Long> temp = new HashSet<>();
        temp.add((long) grid[0][0]);
        dp.get(0).add(temp);
        for (int i = 1; i < grid[0].length; i++) {
            temp = new HashSet<>();
            HashSet<Long> target = dp.get(0).get(i - 1);
            for (long num : target) {
                temp.add(grid[0][i] * num);
            }
            dp.get(0).add(temp);
        }
        for (int i = 1; i < grid.length; i++) {
            temp = new HashSet<>();
            HashSet<Long> target = dp.get(i - 1).get(0);
            for (long num : target) {
                temp.add(grid[i][0] * num);
            }
            dp.get(i).add(temp);
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                temp = new HashSet<>();
                HashSet<Long> target = dp.get(i - 1).get(j);
                for (long num : target) {
                    temp.add((long) ((grid[i][j] * num) % (10e9 + 7)));
                }
                target = dp.get(i).get(j - 1);
                for (long num : target) {
                    temp.add((long) ((grid[i][j] * num) % (10e9 + 7)));
                }
                dp.get(i).add(temp);
            }
        }
        temp = dp.get(grid.length - 1).get(grid[0].length - 1);
        long res = Integer.MIN_VALUE;
        for (long num : temp) {
            if (num > res) {
                res = num;
            }
        }
        return res >= 0 ? (int) (res % (10e9 + 7)) : -1;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }
}
