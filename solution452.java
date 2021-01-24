import java.util.*;

public class solution452 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length < 1) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    if (a[0] > b[0]) {
                        return 1;
                    } else if (a[0] < b[0]) {
                        return -1;
                    } else {
                        return 0;
                    }
                } else {
                    if (a[1] > b[1]) {
                        return 1;
                    } else if (a[1] < b[1]) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });
        int l = points[0][0], r = points[0][1], res = 1;
        for (int[] tmp : points) {
            if (tmp[0] <= r) {
                l = tmp[0];
                r = Math.min(r, tmp[1]);
            } else {
                l = tmp[0];
                r = tmp[1];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        solution452 a = new solution452();
        int[][] i = {{10,16},{2,8},{1,6},{7,12}};
        a.findMinArrowShots(i);
    }
}
