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

    public void rotate1(int[] numbers, int k) {
        final int n = numbers.length;
        k = k % n;
        if (k == 0) return;

        int count = n;
        for (int i = 0; i < n; i++) {
            int tmp = numbers[i];
            int prev = i;
            int curr = n + prev - k;
            while (curr != i) {
                numbers[prev] = numbers[curr];
                count--;
                prev = curr;
                curr = prev < k ? n + prev - k : prev - k;
            }
            numbers[prev] = tmp;
            if (--count == 0) return;
        }
    }

    public void rotate2(int[] numbers, int k) {
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
