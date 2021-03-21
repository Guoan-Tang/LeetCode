import java.util.*;

public class solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> res = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for (int[] cur : intervals) {
            if (cur[0] > newInterval[1] || cur[1] < newInterval[0]) {
                // not intersection
                temp.add(cur[0]);
                temp.add(cur[1]);
                res.add(new ArrayList<>(temp));
                temp.clear();
            } else {
                newInterval[0] = Math.min(newInterval[0], cur[0]);
                newInterval[1] = Math.max(newInterval[1], cur[1]);
            }
        }
        int i = 0;
        int[][] re = new int[res.size() + 1][2];
        while (i < res.size()) {
            if (res.get(i).get(0) > newInterval[0]) {
                break;
            } else {
                re[i][0] = res.get(i).get(0);
                re[i][1] = res.get(i).get(1);
            }
            i++;
        }
        re[i++] = newInterval;
        while (i < re.length) {
            re[i][0] = res.get(i - 1).get(0);
            re[i][1] = res.get(i - 1).get(1);
            i++;
        }
        return re;
    }

    public static void main(String[] args) {
    }
}