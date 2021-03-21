

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class solution71 {
    public String simplifyPath(String path) {
        Deque<String> pathStack = new LinkedList<>();
        for (String curString : path.split("/")) {
            if (curString.equals("..")) {
                if (!pathStack.isEmpty()) {
                    pathStack.pop();
                }
            } else {
                if (!curString.equals(".") && !curString.isEmpty()) {
                    pathStack.push(curString);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        Iterator<String> temp = pathStack.descendingIterator();
        while (temp.hasNext()) {
            String str = temp.next();
            res.append("/" + str);
        }
        return res.length() == 0 ? "/" : res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new solution71().simplifyPath("/../"));
    }
}
