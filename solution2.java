package LeetCode;

public class solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOver = 0;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int[] temp = addTwo(l1, l2, carryOver);
        ListNode res = new ListNode(temp[1]), tempNode = res;
        carryOver = temp[0];
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            temp = addTwo(l1, l2, carryOver);
            tempNode.next = new ListNode(temp[1]);
            carryOver = temp[0];
            l1 = l1.next;
            l2 = l2.next;
            tempNode = tempNode.next;
        }
        while (l1 != null) {
            if (carryOver != 0) {
                temp = addOne(l1, carryOver);
                tempNode.next = new ListNode(temp[1]);
                carryOver = temp[0];
            } else {
                tempNode.next = l1;
            }
            l1 = l1.next;
            tempNode = tempNode.next;
        }
        while (l2 != null) {
            if (carryOver != 0) {
                temp = addOne(l2, carryOver);
                tempNode.next = new ListNode(temp[1]);
                carryOver = temp[0];
            } else {
                tempNode.next = l2;
            }
            l2 = l2.next;
            tempNode = tempNode.next;
        }
        if (carryOver != 0) {
            tempNode.next = new ListNode(carryOver);
        }
        return res;
    }

    public int[] addTwo(ListNode l1, ListNode l2, int carryOver) {
        int[] res = new int[2];
        int num = l1.val + l2.val + carryOver;
        res[1] = num % 10;
        num /= 10;
        res[0] = num;
        return res;
    }

    public int[] addOne(ListNode l1, int carryOver) {
        int[] res = new int[2];
        int num = l1.val + carryOver;
        res[1] = num % 10;
        num /= 10;
        res[0] = num;
        return res;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(2), b = new ListNode(5), temp;
        a.next = new ListNode(4);
        temp = a.next;
        temp.next = new ListNode(3);
        b.next = new ListNode(6);
        temp = b.next;
        temp.next = new ListNode(4);
        System.out.print(new solution2().addTwoNumbers(a, b));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
