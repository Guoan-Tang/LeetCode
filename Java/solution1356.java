import java.util.*;

public class solution1356 {
    public int[] sortByBits(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>(arr.length);
        for (int i : arr) {
            list.add(i);
        }
        Collections.sort(list, new myCmp());
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    class myCmp implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            int ca = count(a), cb = count(b);
            if (ca > cb) {
                return 1;
            } else if (ca < cb) {
                return -1;
            } else {
                return 0;
            }
        }

        public int count(int num) {
            int res = 0, ruler = 1;
            for (int i = 0; i < 31; i++) {
                if ((ruler & num) != 0) {
                    res++;
                }
                ruler <<= 1;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        solution1356 a = new solution1356();
        int b[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        b = a.sortByBits(b);
    }
}