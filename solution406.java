import java.util.*;

public class solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return b[1] - a[1];
                }
            }
        });

        int[][] res = new int[people.length][];
        for (int[] person : people) {
            int space = person[1] + 1;
            for (int i = 0; i < people.length; i++) {
                if (res[i] == null) {
                    space--;
                    if (space == 0) {
                        res[i] = person;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
