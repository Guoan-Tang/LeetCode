public class solutionJ40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length < k || k < 1) {
            return new int[0];
        }
        customQuickSort(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void customQuickSort(int[] arr, int left, int right, int target) {
        if (left >= right) {
            return;
        }
        int mid = core(arr, left, right), sortedNum = mid - left + 1;
        if (sortedNum == target) {
            return;
        } else if (sortedNum < target) {
            customQuickSort(arr, mid + 1, right, target - sortedNum);
        } else {
            customQuickSort(arr, left, mid - 1, target);
        }
    }

    private int core(int[] arr, int left, int right) {
        int pivot = arr[left], pivotPos = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] <= pivot) {
                pivotPos++;
                if (pivotPos != i) {
                    int temp = arr[i];
                    arr[i] = arr[pivotPos];
                    arr[pivotPos] = temp;
                }
            }
        }
        arr[left] = arr[pivotPos];
        arr[pivotPos] = pivot;
        return pivotPos;
    }

    public static void main(String[] args) {
        solutionJ40 s = new solutionJ40();
        int[] input = new int[]{0,0,1,2,4,2,2,3,1,4};
        int[] res = s.getLeastNumbers(input, 8);
        res[0] = 1;
    }
}
