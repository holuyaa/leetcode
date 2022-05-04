package com.leetcode.medium;

public class Q0062 {
    // time out
    public int uniquePaths(int m, int n) {
        final int[] count = new int[1];
        uniquePaths(m, n, 0, 0, count);
        return count[0];
    }

    private void uniquePaths(int m, int n, int y, int x, int[] count) {
        if (y == m - 1 && x == n - 1) count[0]++;
        if (y + 1 < m) uniquePaths(m, n, y + 1, x, count);
        if (x + 1 < n) uniquePaths(m, n, y, x + 1, count);
    }

    public int uniquePaths1(int m, int n) {
        final int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < n; i++) dp[0][i] = 1;

        for (int y = 1; y < m; y++) {
            for (int x = 1; x < n; x++) {
                dp[y][x] = dp[y - 1][x] + dp[y][x - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
