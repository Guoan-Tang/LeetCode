

public class solution657 {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        char[] charArray=moves.toCharArray();
        for (char c:charArray) {
            switch (c) {
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
            }
        }
        return x==0 && y==0;
    }
}
