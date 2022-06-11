package com.leetcode.medium;

public class Q0189 {
    public void rotate(int[] numbers, int k) {
        final int len = numbers.length;
        k = k % len;
        if (k == 0) return;

        final int[] tmp = new int[k];
        System.arraycopy(numbers, len - k, tmp, 0, k);
        System.arraycopy(numbers, 0, numbers, k, len - k);
        System.arraycopy(tmp, 0, numbers, 0, k);
    }
}
