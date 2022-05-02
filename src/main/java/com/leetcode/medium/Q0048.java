package com.leetcode.medium;

public class Q0048 {
    public void rotate(int[][] matrix) {
        final int n = matrix.length - 1;
        for (int y = 0; y < (matrix.length + 1) / 2; y++) {
            for (int x = 0; x < matrix.length / 2; x++) {
                swap(matrix, y, x, n);
            }
        }
    }

    private void swap(int[][] matrix, int y, int x, int n) {
        int tmp = matrix[y][x];
        matrix[y][x] = matrix[n - x][y];
        matrix[n - x][y] = matrix[n - y][n - x];
        matrix[n - y][n - x] = matrix[x][n - y];
        matrix[x][n - y] = tmp;
    }
}
