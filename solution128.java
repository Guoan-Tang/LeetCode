package LeetCode;

import java.util.HashMap;

public class solution128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int res = 1;
        HashMap<Integer, Integer> lengthRecord = new HashMap<>();
        for (int i : nums) {
            if (!lengthRecord.containsKey(i)) {
                // new key
                Integer leftLength = lengthRecord.get(i - 1);
                Integer rightLength = lengthRecord.get(i + 1);
                if (leftLength == null) {
                    if (rightLength == null) {
                        lengthRecord.put(i, 1);
                    } else {
                        int totalLength = rightLength + 1;
                        lengthRecord.put(i, totalLength);
                        lengthRecord.put(i + rightLength, totalLength);
                        if (totalLength > res) {
                            res = totalLength;
                        }
                    }
                } else {
                    if (rightLength == null) {
                        int totalLength = leftLength + 1;
                        lengthRecord.put(i, totalLength);
                        lengthRecord.put(i - leftLength, totalLength);
                        if (totalLength > res) {
                            res = totalLength;
                        }
                    } else {
                        int totalLength = leftLength + rightLength + 1;
                        lengthRecord.put(i + rightLength, totalLength);
                        lengthRecord.put(i - leftLength, totalLength);
                        lengthRecord.put(i, 1);
                        if (totalLength > res) {
                            res = totalLength;
                        }
                    }
                }
            }
        }
        return res;
    }
}
