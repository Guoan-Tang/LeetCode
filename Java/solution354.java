

public class solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        int maxW = 0, maxH = 0, res = 0;
        for (int i = 0; i < envelopes.length; i++) {
            if (envelopes[i][0] > maxW) {
                maxW = envelopes[i][0];
            }
            if (envelopes[i][1] > maxH) {
                maxH = envelopes[i][1];
            }
        }
        boolean[] usedW = new boolean[maxW], usedH = new boolean[maxH];
        for (int i = 0; i < envelopes.length; i++) {
            int w = envelopes[i][0], h = envelopes[i][1];
            if (!usedW[w - 1] && !usedH[h - 1]) {
                res++;
                usedW[w - 1] = true;
                usedH[h - 1] = true;
            }
        }
        return res;
    }
}
