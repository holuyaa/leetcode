package com.leetcode.medium;

public class Q0198 {
    public int rob(int[] numbers) {
        final int n = numbers.length;
        if (n == 1) return numbers[0];
        if (n == 2) return Math.max(numbers[0], numbers[1]);

        final int[] dp = new int[n];
        dp[0] = numbers[0];
        dp[1] = Math.max(numbers[0], numbers[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + numbers[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
