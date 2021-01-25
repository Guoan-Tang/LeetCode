package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solution56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 1) {
            return new int[0][0];
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] current = intervals[0];
        List<int[]> res = new ArrayList<>();
        for (int[] temp : intervals) {
            if (temp[0] > current[1]) {
                // partition
                res.add(current);
                current = new int[2];
                current[0] = temp[0];
                current[1] = temp[1];
            } else {
                if(current[1] < temp[1])
                    current[1] = temp[1];
            }
        }
        res.add(current);
        return res.toArray(new int[0][]);
    }
}
