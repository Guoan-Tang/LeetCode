import java.util.*;

public class solution1030 {
    int x0, y0;

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        x0 = r0;
        y0 = c0;
        int z = 0;
        int[][] res = new int[R * C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int[] tmp = new int[2];
                tmp[0] = i;
                tmp[1] = j;
                res[z++] = tmp;
            }
        }
        Arrays.sort(res, new Comparator<int[]>() {
            public int compare(int[] A, int[] B) {
                return (Math.abs(A[0] - x0) + Math.abs(A[1] - y0)) - (Math.abs(B[0] - x0) + Math.abs(B[1] - y0));
            }
        });
        return res;
    }
}