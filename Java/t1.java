public class t1 {

    public static boolean solution(int[] input) {
        if (input.length < 1) {
            return false;
        }
        int sum = 0;
        boolean[] used = new boolean[input.length];
        for (int i : input) {
            sum += i;
        }
        if (sum % 4 != 0) {
            return false;
        }
        return recursive(input, used, 0, 0, sum / 4);
    }

    public static boolean recursive(int[] input, boolean[] used, int currentSum, int edgeCount, int oneEdgeTarget) {
        if (edgeCount == 4) {
            return true;
        }
        // 每次只选一条边
        for (int i = 0; i < input.length; i++) {
            // 没用过，长度不超过，就选
            if (!used[i]) {
                if (input[i] + currentSum < oneEdgeTarget) {
                    used[i] = true;
                    if (recursive(input, used, currentSum + input[i], edgeCount, oneEdgeTarget)) {
                        return true;
                    } else {
                        // 这条边不行，换下一条
                        used[i] = false;
                    }
                } else if (input[i] + currentSum == oneEdgeTarget) {
                    // 刚好
                    used[i] = true;
                    if (recursive(input, used, 0, edgeCount + 1, oneEdgeTarget)) {
                        return true;
                    } else {
                        used[i] = false;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {4,3,2,5,1,7,6};
        if (solution(input)) {
            System.out.println("true");
        } else {
            System.out.println("false"); 
        }
    }
}