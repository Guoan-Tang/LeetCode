import java.util.*;

public class solution228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (nums == null || nums.length < 1) {
            return new LinkedList<String>();
        }
        if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
        }
        boolean isContinuous = false;
        int preNum = nums[0], curNum, startNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curNum = nums[i];
            if (curNum - preNum == 1) {
                if (!isContinuous) {
                    startNum = preNum;
                    isContinuous = true;
                }
            } else {
                if (isContinuous) {
                    res.add(String.format("%d->%d", startNum, preNum));
                    isContinuous = false;
                } else {
                    res.add(String.valueOf(nums[i]));
                    if (i == 1 || i > 1 && nums[i - 2] + 1 != nums[i - 1]) {
                        res.add(String.valueOf(nums[i - 1]));
                    }
                }
            }
            preNum = curNum;
        }
        if (isContinuous) {
            res.add(String.format("%d->%d", startNum, preNum));
        } else {
            res.add(String.valueOf(preNum));
        }
        return res;
    }
}