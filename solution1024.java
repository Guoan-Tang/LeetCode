package LeetCode;

public class solution1024 {
    public static int videoStitching(int[][] clips, int T) {
        int[] maxn = new int[T];
        int last = 0, pre = 0, res = 0;
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
            }
        }
        for (int i = 0; i < T; i++) {
            last = Math.max(maxn[i], last);
            if (i == pre) {
                pre = last;
                res++;
            }
            if (i == last) {
                return -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] clips = { { 0, 2 }, { 4, 6 }, { 8, 10 }, { 1, 9 }, { 1, 5 }, { 5, 9 } };
        videoStitching(clips, 10);
    }
}
