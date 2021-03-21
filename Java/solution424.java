public class solution424 {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        char[] sc = s.toCharArray();
        int l = 0, r = 0, max = 0;
        while (r < sc.length) {
            count[sc[r] - 'A']++;
            max = Math.max(count[sc[r] - 'A'], max);
            if (r - l + 1 - max > k) {
                count[sc[l++] - 'A']--;
            }
            r++;
        }
        return r - l;
    }
}