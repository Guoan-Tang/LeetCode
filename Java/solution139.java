import java.util.*;

public class solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()];
        HashSet<String> wordSet = new HashSet<>();
        for (String curS : wordDict) {
            wordSet.add(curS);
        }
        dp[0] = wordSet.contains(s.substring(0, 1)) ? true : false;
        for (int i = 1; i < dp.length; i++) {
            if (wordSet.contains(s.substring(0, i + 1))) {
                dp[i] = true;
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && wordSet.contains(s.substring(j + 1, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        solution139 sl = new solution139();
        String s = "leetcode";
        List<String> dict = new ArrayList<>(2);
        dict.add("leet");
        dict.add("code");
        System.out.print(sl.wordBreak(s, dict));
    }
}