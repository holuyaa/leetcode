package com.leetcode.medium;

public class Q0221 {

    /* brute force  - timeout*/
    public int maximalSquare(char[][] matrix) {
        int maxArea = 0;
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                if (matrix[y][x] == '0') continue;
                maxArea = Math.max(maxArea, getSquareArea(matrix, x, y));
            }
        }
        return maxArea;
    }

    private int getSquareArea(char[][] matrix, int startX, int startY) {
        final int n = Math.min(matrix[startY].length - startX, matrix.length - startY);
        int i = 1;
        for (; i < n; i++) {
            if (!isSquare(matrix, startX, startY, i)) break;
        }
        return i * i;
    }

    private boolean isSquare(char[][] matrix, int startX, int startY, int n) {
        final int endX = startX + n;
        final int endY = startY + n;
        for (int i = startX; i < endX; i++) {
            System.out.println(matrix[startY + n][i]);
            if (matrix[endY][i] != '1') return false;
        }

        for (int i = startY; i < endY; i++) {
            System.out.println(matrix[i][endX]);
            if (matrix[i][startX + n] != '1') return false;
        }

        return matrix[endY][endX] == '1';
    }
}
