import java.util.*;

public class solution1046 {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> myQueue = new PriorityQueue<Integer>((a, b) -> {return b - a;});
        for (int i : stones) {
            myQueue.offer(i);
        }
        while (myQueue.size() > 1) {
            int a = myQueue.poll();
            int b = myQueue.poll();
            if (a > b) {
                myQueue.offer(a - b);
            }
        }
        return myQueue.size() == 0 ? 0 :myQueue.poll();
    }
}
