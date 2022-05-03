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

    public void rotate1(int[][] matrix) {
        // transpose and then reflect (left to right)
        transpose(matrix);
        reflect1(matrix);
    }

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                final int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    private void reflect1(int[][] matrix) {
        final int n = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                final int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j];
                matrix[i][n - j] = tmp;
            }
        }
    }

    public void rotate2(int[][] matrix) {
        // reflect (up to down) and then transpose
        reflect2(matrix);
        transpose(matrix);
    }

    private void reflect2(int[][] matrix) {
        final int n = matrix.length - 1;
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                final int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - i][j];
                matrix[n - i][j] = tmp;
            }
        }
    }
}
