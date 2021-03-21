import java.util.*;

public class solution989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
       LinkedList<Integer> k = new LinkedList<>();
       while (K != 0) {
          k.addFirst(K % 10);
          K /= 10; 
       }
       LinkedList<Integer> res = new LinkedList<>();
       int i = A.length - 1, j = k.size() - 1, carryNum = 0;
       while (i >= 0 && j >= 0) {
           carryNum += (A[i--] + k.get(j--));
           res.addFirst(carryNum % 10);
           carryNum /= 10;
       }
       while (i != 0) {
           carryNum += A[i--];
           res.addFirst(carryNum % 10);
           carryNum /= 10;
       }
       while (j != 0) {
           carryNum += k.get(j--); 
           res.addFirst(carryNum % 10);
           carryNum /= 10;
       }
       if (carryNum != 0) {
           res.addFirst(carryNum);
       }
       return res;
    }
}
