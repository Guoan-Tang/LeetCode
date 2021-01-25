package LeetCode;

import java.util.*;

public class solution52 {
    boolean[][] attack;
    int res;
    Set<Integer> diagonal1, diagonal2, rows;

    public int totalNQueens(int n) {
        attack = new boolean[n][n];
        res = 0;
        diagonal1 = new HashSet<>();
        diagonal2 = new HashSet<>();
        rows = new HashSet<>();
        recall(0, n);
        return res;
    }

    public void recall(int count, int n) {
        if (count == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (rows.contains(i) || diagonal1.contains(count + i) || diagonal2.contains(count - i)) {
                continue;
            }
            rows.add(i);
            diagonal1.add(count + i);
            diagonal2.add(count - i);
            recall(count + 1, n);
            rows.remove(i);
            diagonal1.remove(count + i);
            diagonal2.remove(count - i);
        }
    }

    public void attack(int x, int y, int n) {
        for (int i = 0; i < n; i++) {
            attack[i][y] = true;
            attack[x][i] = true;
        }
        int tempX = x, tempY = y;
        while (tempX >= 0 && tempX < n && tempY >= 0 && tempY < n) {
            attack[tempX][tempY] = true;
            tempX--;
            tempY++;
        }
        tempX = x;
        tempY = y;
        while (tempX >= 0 && tempX < n && tempY >= 0 && tempY < n) {
            attack[tempX][tempY] = true;
            tempX++;
            tempY--;
        }
        tempX = x;
        tempY = y;
        while (tempX >= 0 && tempX < n && tempY >= 0 && tempY < n) {
            attack[tempX][tempY] = true;
            tempX++;
            tempY++;
        }
        tempX = x;
        tempY = y;
        while (tempX >= 0 && tempX < n && tempY >= 0 && tempY < n) {
            attack[tempX][tempY] = true;
            tempX--;
            tempY--;
        }
    }

    public void deAttack(int x, int y, int n) {
        for (int i = 0; i < n; i++) {
            attack[i][y] = false;
            attack[x][i] = false;
        }
        int tempX = x, tempY = y;
        while (tempX >= 0 && tempX < n && tempY >= 0 && tempY < n) {
            attack[tempX][tempY] = false;
            tempX--;
            tempY++;
        }
        tempX = x;
        tempY = y;
        while (tempX >= 0 && tempX < n && tempY >= 0 && tempY < n) {
            attack[tempX][tempY] = false;
            tempX++;
            tempY--;
        }
        tempX = x;
        tempY = y;
        while (tempX >= 0 && tempX < n && tempY >= 0 && tempY < n) {
            attack[tempX][tempY] = false;
            tempX++;
            tempY++;
        }
        tempX = x;
        tempY = y;
        while (tempX >= 0 && tempX < n && tempY >= 0 && tempY < n) {
            attack[tempX][tempY] = false;
            tempX--;
            tempY--;
        }
    }
}