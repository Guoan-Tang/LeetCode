public class solutionJ58_2 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        char[] sc = s.toCharArray();
        int index = n;
        for (int i = 0; i < sc.length; i++) {
            res.append(sc[(i + index) % sc.length]);
        }
        return res.toString();
    }
}
