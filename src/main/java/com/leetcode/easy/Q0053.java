package com.leetcode.easy;

public class Q0053 {

    public int maxSubArray(int[] numbers) {
        int max = numbers[0];
        int sum = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            sum = Math.max(sum + numbers[i], numbers[i]);
            max = Math.max(sum, max);
        }
        return max;
    }
}
