

import java.util.ArrayList;
import java.util.HashSet;

public class solution37 {
    private ArrayList<HashSet<Character>> cols;
    private ArrayList<HashSet<Character>> rows;
    private ArrayList<HashSet<Character>> blocks;
    private char[] letters = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    public void solveSudoku(char[][] board) {
        cols = new ArrayList<>(9);
        rows = new ArrayList<>(9);
        blocks = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            cols.add(new HashSet<Character>());
            rows.add(new HashSet<Character>());
            blocks.add(new HashSet<Character>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rows.get(i).add(board[i][j]);
                    cols.get(j).add(board[i][j]);
                    blocks.get(i / 3 * 3 + j / 3).add(board[i][j]);
                }
            }
        }
        recursion(board, 0, 0);
    }

    public boolean recursion(char[][] board, int i, int j) {
        if (j == 9) {
            if (i == 8) {
                return true;
            }
            j = 0;
            i++;
        }
        while (board[i][j] != '.') {
            if (j == 8) {
                if (i == 8) {
                    return true;
                }
                j = 0;
                i++;
            } else {
                j++;
            }
        }
        for (char c : letters) {
            if (!cols.get(j).contains(c) && !rows.get(i).contains(c) && !blocks.get(i / 3 * 3 + j / 3).contains(c)) {
                cols.get(j).add(c);
                rows.get(i).add(c);
                blocks.get(i / 3 * 3 + j / 3).add(c);
                board[i][j] = c;
                if (recursion(board, i, j + 1)) {
                    return true;
                }
                cols.get(j).remove(c);
                rows.get(i).remove(c);
                blocks.get(i / 3 * 3 + j / 3).remove(c);
            }
        }
        return false;
    }
}
