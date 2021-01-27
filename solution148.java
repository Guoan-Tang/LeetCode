

public class solution148 {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }

        // recursive boundary
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            ListNode temp = head.next;
            if (head.val > temp.val) {
                head.next = null;
                temp.next = head;
                return temp;
            } else {
                return head;
            }
        }

        // divide the linkedlist into two parts
        ListNode left = head, right = head;
        while (right != null) {
            right = right.next;
            if (right == null) {
                break;
            } else {
                right = right.next;
            }
            left = left.next;
        }

        // sort two parts

        right = sortList(left.next);
        left.next = null;
        left = sortList(head);

        // merge them to one linkedlist
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode res, temp;
        if (left.val < right.val) {
            res = left;
            left = left.next;
        } else {
            res = right;
            right = right.next;
        }
        temp = res;
        while (left != null && right != null) {
            if (left.val > right.val) {
                temp.next = right;
                right = right.next;
            } else {
                temp.next = left;
                left = left.next;
            }
            temp = temp.next;
        }
        if (left != null) {
            temp.next = left;
        }
        if (right != null) {
            temp.next = right;
        }
        return res;
    }

    public static void main(String[] args) {
        solution148 solution = new solution148();
        ListNode head = solution.new ListNode(4), temp = head;
        temp.next = solution.new ListNode(2);
        temp = temp.next;
        temp.next = solution.new ListNode(1);
        temp = temp.next;
        temp.next = solution.new ListNode(3);
        //System.out.println(solution.sortList(head));
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    // ************************transform the LinkedList to array, link them again
    // after soring the
    // array***************************************** */
    // public ListNode sortList(ListNode head) {
    // if(head==null){
    // return null;
    // }
    // ArrayList<ListNode> nodeList = new ArrayList<ListNode>();
    // while (head != null) {
    // nodeList.add(head);
    // head = head.next;
    // }
    // ListNode[] arrayListNode = new ListNode[nodeList.size()];
    // for (int i = 0; i < arrayListNode.length; i++) {
    // arrayListNode[i] = nodeList.get(i);
    // }
    // Arrays.sort(arrayListNode, (v1, v2) -> v1.val - v2.val);
    // ListNode res = arrayListNode[0], temp = res;
    // for (int i = 1; i < arrayListNode.length; i++) {
    // temp.next = arrayListNode[i];
    // temp = temp.next;
    // }
    // arrayListNode[arrayListNode.length - 1].next = null;
    // return res;
    // }
}
