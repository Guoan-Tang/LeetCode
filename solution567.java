public class solution567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        int count = s1.length();
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }
        char[] sc = s2.toCharArray();
        int l = 0, r = 0;
        int[] freq0 = new int[26];
        while (r < sc.length) {
            if (freq[sc[r] - 'a'] != 0) {
                if (freq0[sc[r] - 'a'] < freq[sc[r] - 'a']) {
                    freq0[sc[r] - 'a']++;
                    count--;
                    if (count == 0) {
                        return true;
                    }
                } else {
                    while (sc[l] != sc[r]) {
                        freq0[sc[l++] - 'a']--;
                        count++;
                    }
                    freq0[sc[l++] - 'a']--;
                    count++;
                    r--;
                }
            } else {
                while (l != r) {
                    freq0[sc[l++] - 'a']--;
                    count++;
                }
                l++;
            }
            r++;
        }
        return false;
    }

    // public boolean checkInclusion(String s1, String s2) {
    //     if (s1.length() > s2.length())
    //         return false;
    //     if (s1.length() < 1)
    //         return false;
    //     HashMap<Character, Integer> charIns1 = new HashMap<>();
    //     char[] charArray = s1.toCharArray(), targetArray = s2.toCharArray();
    //     Integer temp;
    //     for (char c : charArray) {
    //         temp = charIns1.get(c);
    //         if (temp == null) {
    //             charIns1.put(c, 1);
    //         } else {
    //             charIns1.put(c, temp + 1);
    //         }
    //     }

    //     for (int i = 0; i <= s2.length() - s1.length(); i++) {
    //         //traversal s2
    //         if (charIns1.get(targetArray[i]) != null) {
    //             HashMap<Character, Integer> tempMap = new HashMap<>(charIns1);
    //             tempMap.put(targetArray[i], tempMap.get(targetArray[i]) - 1);
    //             boolean match = true;
    //             for (int j = 1; j < s1.length(); j++) {
    //                 temp = tempMap.get(targetArray[i + j]);
    //                 if (temp == null || temp < 1) {
    //                     // no matched char in tempMap
    //                     match = false;
    //                     break;
    //                 } else {
    //                     // the number of this char decrease
    //                     tempMap.put(targetArray[i + j], temp - 1);
    //                 }
    //             }
    //             if (match) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
}
