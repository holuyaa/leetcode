package com.leetcode.medium;

public class Q0152 {
    public int maxProduct(int[] numbers) {
        final int len = numbers.length;
        int max = numbers[0];
        int maxProduct = max;
        int minProduct = max;
        for (int i = 1; i < len; i++) {
            final int num = numbers[i];
           if (num < 0) {
               final int tmp = maxProduct;
               maxProduct = Math.max(minProduct * num, num);
               minProduct = Math.min(tmp * num, num);
           } else {
               maxProduct = Math.max(maxProduct * num, num);
               minProduct = Math.min(minProduct * num, num);
           }
           max = Math.max(max, maxProduct);
        }
        return max;
    }
}
