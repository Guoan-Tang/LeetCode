

public class solution79 {
    private boolean[][] hadVisited;

    public boolean exist(char[][] board, String word) {
        if (board.length < 1 || board[0].length < 1 || word.length() < 1) {
            return false;
        }
        hadVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (findPath(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findPath(char[][] board, int row, int col, String word, int wordIndex) {
        if (wordIndex == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) {
            return false;
        }
        if (hadVisited[row][col]) {
            return false;
        }
        if (board[row][col] == word.charAt(wordIndex)) {
            hadVisited[row][col] = true;
            if (findPath(board, row + 1, col, word, wordIndex + 1)
                    || findPath(board, row - 1, col, word, wordIndex + 1)
                    || findPath(board, row, col + 1, word, wordIndex + 1)
                    || findPath(board, row, col - 1, word, wordIndex + 1)) {
                return true;
            } else {
                hadVisited[row][col] = false;
            }
        }
        return false;
    }
}