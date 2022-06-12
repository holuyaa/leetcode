package com.leetcode.medium;

public class Q0189 {
    public void rotate(int[] numbers, int k) {
        final int n = numbers.length;
        k = k % n;
        if (k == 0) return;

        final int[] tmp = new int[k];
        System.arraycopy(numbers, n - k, tmp, 0, k);
        System.arraycopy(numbers, 0, numbers, k, n - k);
        System.arraycopy(tmp, 0, numbers, 0, k);
    }

    public void rotate1(int[] numbers, int k) {
        final int n = numbers.length;
        k = k % n;
        if (k == 0) return;

        reverse(numbers, 0, n - 1);
        reverse(numbers, 0, k - 1);
        reverse(numbers, k, n - 1);
    }

    private void reverse(int[] numbers, int start, int end) {
        for (; start <= end; start++, end--) {
            final int tmp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = tmp;
        }
    }
}
