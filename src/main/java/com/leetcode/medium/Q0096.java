package com.leetcode.medium;

public class Q0096 {
    public int numTrees(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        final int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
