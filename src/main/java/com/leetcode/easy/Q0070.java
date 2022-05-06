package com.leetcode.easy;

public class Q0070 {
    // timeout
    public int climbStairs(int n) {
        final int[] count = new int[1];
        climbStairs(n, 0, count);
        return count[0];
    }

    private void climbStairs(int n, int sum, int[] count) {
        if (sum == n) {
            count[0]++;
            return;
        }
        if (sum + 1 <= n) climbStairs(n, sum + 1, count);
        if (sum + 2 <= n) climbStairs(n, sum + 2, count);
    }

    public int climbStairs1(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        final int[] fibo = new int[n + 1];
        fibo[1] = 1;
        fibo[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        return fibo[n];
    }
}
