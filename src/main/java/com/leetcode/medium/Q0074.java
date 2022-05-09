package com.leetcode.medium;

public class Q0074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            final int mid = (left + right) / 2;
            final int midX = mid % n;
            final int midY = mid / n;
            if (matrix[midY][midX] < target) left = mid + 1;
            else if (target < matrix[midY][midX]) right = mid - 1;
            else return true;
        }
        return false;
    }

    public Boolean searchMatrix1(int[][] matrix, int target) {
        int y = 0;
        int x = matrix[0].length - 1;
        while (y < matrix.length && 0 <= x) {
            if (matrix[y][x] < target) y++;
            else if (target < matrix[y][x]) x--;
            else return true;
        }
        return false;
    }
}
