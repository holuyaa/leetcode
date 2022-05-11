package com.leetcode.medium;

public class Q0079 {
    public boolean exist(char[][] board, String word) {
        final int m = board.length;
        final int n = board[0].length;
        final char[] chars = word.toCharArray();
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (board[y][x] == chars[0] && check(board, chars, new boolean[m][n], x, y, 0)) return true;
            }
        }
        return false;
    }

    private boolean check(char[][] board, char[] word, boolean[][] visited, int x, int y, int pos) {
        if (board[y][x] != word[pos]) return false;
        if (pos == word.length - 1) return true;
        visited[y][x] = true;
        if (0 < x && !visited[y][x - 1]) {
            if (check(board, word, visited, x - 1, y, pos + 1)) return true;
            visited[y][x - 1] = false;
        }
        if (0 < y && !visited[y - 1][x]) {
            if (check(board, word, visited, x, y - 1, pos + 1)) return true;
            visited[y - 1][x] = false;
        }
        if (x + 1 < board[0].length && !visited[y][x + 1]) {
            if (check(board, word, visited, x + 1, y, pos + 1)) return true;
            visited[y][x + 1] = false;
        }
        if (y + 1 < board.length && !visited[y + 1][x]) {
            if (check(board, word, visited, x, y + 1, pos + 1)) return true;
            visited[y + 1][x] = false;
        }
        return false;
    }

    public boolean exist1(char[][] board, String word) {
        final int m = board.length;
        final int n = board[0].length;
        final char[] chars = word.toCharArray();
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (check1(board, chars, x, y, 0)) return true;
            }
        }
        return false;
    }

    private boolean check1(char[][] board, char[] word, int x, int y, int pos) {
        if (pos == word.length) return true;
        if (x < 0 || y < 0 || x == board[0].length || y == board.length) return false;
        if (board[y][x] != word[pos]) return false;
        board[y][x] = '*';
        final boolean exist = check1(board, word, x - 1, y, pos + 1) ||
                check1(board, word, x, y - 1, pos + 1) ||
                check1(board, word, x + 1, y, pos + 1) ||
                check1(board, word, x, y + 1, pos + 1);
        board[y][x] = word[pos];
        return exist;
    }
}
