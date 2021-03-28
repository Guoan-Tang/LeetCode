import java.util.PriorityQueue;

public class solution703 {
    class KthLargest {
        private PriorityQueue<Integer> pq;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.pq = new PriorityQueue<>();
            for (int num : nums) {
                pq.add(num);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        public int add(int val) {
            pq.add(val);
            if (pq.size() > k) {
                pq.poll();
            }
            return pq.peek();
        }
    }

    class KthLargest0 {
        // kth large, need smallest heap
        private int[] heap;

        public KthLargest0(int k, int[] nums) {
            int len = nums.length;
            heap = new int[k];
            // select k small element
            for (int i = len / 2; i >= 0; i--) {
                MaxHeapify(nums, i, len);
            }
            for (int i = 0; i < k && i < nums.length; i++) {
                heap[i] = nums[0];
                nums[0] = nums[nums.length - 1 - i];
                MaxHeapify(nums, 0, len - 1 - i);
            }
            for (int i = nums.length; i < k; i++) {
                heap[i] = Integer.MIN_VALUE;
            }
            for (int i = k / 2; i >= 0; i--) {
                MinHeapify(heap, i);
            }
        }

        public int add(int val) {
            if (val > heap[0]) {
                heap[0] = val;
                MinHeapify(heap, 0);
            }
            return heap[0];
        }

        private void MaxHeapify(int[] nums, int index, int totalCount) {
            int largestIndex = index, leftIndex = 2 * index + 1, rightIndex = 2 * index + 2;
            if (leftIndex < totalCount && nums[leftIndex] > nums[largestIndex]) {
                largestIndex = leftIndex;
            }
            if (rightIndex < totalCount && nums[rightIndex] > nums[largestIndex]) {
                largestIndex = rightIndex;
            }
            if (largestIndex != index) {
                int temp = nums[largestIndex];
                nums[largestIndex] = nums[index];
                nums[index] = temp;
                MaxHeapify(nums, largestIndex, totalCount);
            }
        }

        private void MinHeapify(int[] nums, int index) {
            int leastIndex = index, leftIndex = 2 * index + 1, rightIndex = 2 * index + 2;
            if (leftIndex < nums.length && nums[leftIndex] < nums[leastIndex]) {
                leastIndex = leftIndex;
            }
            if (rightIndex < nums.length && nums[rightIndex] < nums[leastIndex]) {
                leastIndex = rightIndex;
            }
            if (leastIndex != index) {
                int temp = nums[leastIndex];
                nums[leastIndex] = nums[index];
                nums[index] = temp;
                MinHeapify(nums, leastIndex);
            }
        }
    }

    public static void main(String[] args) {
        int[] input = { 4, 5, 2, 8 };
        KthLargest0 kt = new solution703().new KthLargest0(3, input);
        System.out.println(kt.add(3));
        System.out.println(kt.add(5));
        System.out.println(kt.add(10));
    }
}