package com.leetcode.medium;

public class Q0221 {

    /* brute force */
    public int maximalSquare(char[][] matrix) {
        final int lenX = matrix[0].length;
        final int lenY = matrix.length;
        int maxLen= 0;
        for (int y = 0; y < lenY; y++) {
            for (int x = 0; x < lenX; x++) {
                if (matrix[y][x] == '0') continue;
                final int n = Math.min(lenX - x, lenY - y);
                if (maxLen < n) maxLen = Math.max(maxLen, getMaxLen(matrix, x, y, n));
            }
        }
        return maxLen * maxLen;
    }

    private int getMaxLen(char[][] matrix, int startX, int startY, int n) {
        int i = 1;
        for (; i < n; i++) {
            if (!isSquare(matrix, startX, startY, i)) break;
        }
        return i;
    }

    private boolean isSquare(char[][] matrix, int startX, int startY, int n) {
        final int endX = startX + n;
        final int endY = startY + n;

        for (int i = startX; i < endX; i++) {
            if (matrix[endY][i] != '1') return false;
        }

        for (int i = startY; i < endY; i++) {
            if (matrix[i][startX + n] != '1') return false;
        }

        return matrix[endY][endX] == '1';
    }
}
