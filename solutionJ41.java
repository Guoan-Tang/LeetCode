import java.util.*;

public class solutionJ41 {

    static class MedianFinder {
        private Queue<Integer> increaseHeap, decreaseHeap;
    
        public MedianFinder() {
            increaseHeap = new PriorityQueue<>((Integer a, Integer b) -> (b - a));
            decreaseHeap = new PriorityQueue<>();
        }
    
        public void addNum(int num) {
            if (increaseHeap.size() == decreaseHeap.size()) {
                decreaseHeap.offer(num);
                increaseHeap.offer(decreaseHeap.poll());
            } else {
                increaseHeap.offer(num);
                decreaseHeap.offer(increaseHeap.poll());
            }
        }
    
        public double findMedian() {
            double res = -1;
            if (increaseHeap.size() == decreaseHeap.size()) {
                res = (increaseHeap.peek() + decreaseHeap.peek()) / 2;
            } else {
                res = increaseHeap.peek();
            }
            return res;
        }
    }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());
    }
}