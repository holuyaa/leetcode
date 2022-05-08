package com.leetcode.medium;

public class Q0073 {
    public void setZeroes(int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        final boolean[] rows = new boolean[m];
        final boolean[] columns = new boolean[n];
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (matrix[y][x] == 0) {
                    rows[y] = true;
                    columns[x] = true;
                }
            }
        }
        for (int y = 0; y < m; y++) {
            if (rows[y]) {
                for (int x = 0; x < n; x++) matrix[y][x] = 0;
            }
        }
        for (int x = 0; x < n; x++) {
            if (columns[x]) {
                for (int y = 0; y < m; y++) matrix[y][x] = 0;
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        final boolean[] first = new boolean[2];
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                first[0] = true;
                break;
            }
        }
        for (int x = 0; x < n; x++) {
            if (matrix[0][x] == 0) {
                first[1] = true;
                break;
            }
        }
        for (int y = 1; y < m; y++) {
            for (int x = 1; x < n; x++) {
                if (matrix[y][x] == 0) {
                    matrix[y][0] = 0;
                    matrix[0][x] = 0;
                }
            }
        }
        for (int y = 1; y < m; y++) {
            if (matrix[y][0] == 0) {
                for (int x = 1; x < n; x++) matrix[y][x] = 0;
            }
        }
        for (int x = 1; x < n; x++) {
            if (matrix[0][x] == 0) {
                for (int y = 1; y < m; y++) matrix[y][x] = 0;
            }
        }
        if (first[0]) {
            for (int y = 0; y < m; y++) matrix[y][0] = 0;
        }
        if (first[1]) {
            for (int x = 0; x < n; x++) matrix[0][x] = 0;
        }
    }
}
