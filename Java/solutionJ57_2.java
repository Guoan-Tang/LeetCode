import java.util.*;

public class solutionJ57_2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new LinkedList<>();
        int l = 1, r = 1, sum = 0;
        int[] temp;
        while (l <= target / 2) {
            if (sum < target) {
                sum += r;
                r++;
            } else if (sum > target) {
                sum -= l;
                l++;
            } else {
                temp = new int[r - l];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = l + i;
                }
                res.add(temp);
                l++;
            }
        }
        int[][] ret = new int[res.size()][];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}
