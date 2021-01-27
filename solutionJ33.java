

public class solutionJ33 {
    public boolean verifyPostorder(int[] postorder) {
        return core(postorder, 0, postorder.length - 1);
    }

    public boolean core(int[] postorder, int left, int right) {
        if (left >= right - 1) {
            return true;
        }
        int head = postorder[right];
        int mid = left;
        while (mid < right) {
            if (postorder[mid] > head) {
                break;
            }
            mid++;
        }

        for (int i = mid + 1; i < right; i++) {
            if (postorder[i] < head) {
                return false;
            }
        }

        return core(postorder, left, mid - 1) && core(postorder, mid, right - 1);
    }
}
