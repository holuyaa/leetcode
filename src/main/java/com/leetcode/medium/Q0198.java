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

    public int rob1(int[] numbers) {
        return rob1(numbers, numbers.length - 1);
    }

    private int rob1(int[] numbers, int pos) {
        if (pos == 0) return numbers[0];
        if (pos < 0) return 0;

        return Math.max(numbers[pos] + rob1(numbers, pos - 2), rob1(numbers, pos - 1));
    }
}
