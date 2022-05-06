package com.leetcode.medium;

public class Q0064 {
    public int minPathSum(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        final int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];
        for (int i = 1; i < n; i++) dp[0][i] = dp[0][i - 1] + grid[0][i];
        for (int y = 1; y < m; y++) {
            for (int x = 1; x < n; x++) {
                dp[y][x] = Math.min(dp[y - 1][x], dp[y][x - 1]) + grid[y][x];
            }
        }
        return dp[m - 1][n - 1];
    }
}
