

import java.util.Deque;
import java.util.LinkedList;

public class solution415 {
    public String addStrings(String num1, String num2) {
        char[] sc1 = num1.toCharArray(), sc2 = num2.toCharArray();
        int index1 = sc1.length - 1, index2 = sc2.length - 1;
        Deque<Character> resBuffer = new LinkedList<>();
        char[] temp = new char[2];
        temp[0] = '0';
        temp[1] = '0';
        while (index1 >= 0 && index2 >= 0) {
            temp = caculate(sc1[index1], sc2[index2], temp[0]);
            resBuffer.addFirst(temp[1]);
            index1--;
            index2--;
        }
        while (index1 >= 0) {
            temp = caculate(sc1[index1], '0', temp[0]);
            resBuffer.addFirst(temp[1]);
            index1--;
        }
        while (index2 >= 0) {
            temp = caculate(sc2[index2], '0', temp[0]);
            resBuffer.addFirst(temp[1]);
            index2--;
        }
        if (temp[0] != '0') {
            resBuffer.addFirst(temp[0]);
        }
        StringBuffer res = new StringBuffer();
        for (; resBuffer.size() != 0;) {
            res.append(resBuffer.pollFirst());
        }
        return res.toString();
    }

    public char[] caculate(char c1, char c2, char carryOver) {
        int num = c1 + c2 + carryOver - 3 * '0';
        int unit = num % 10 + '0', tens = num / 10 + '0';
        char[] res = new char[2];
        res[0] = (char) tens;
        res[1] = (char) unit;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new solution415().addStrings("1", "9"));
    }
}
