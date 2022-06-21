package com.leetcode.medium;

import java.util.Arrays;

public class Q0215 {
    public int findKthLargest(int[] numbers, int k) {
        Arrays.sort(numbers);
        return numbers[numbers.length - k];
    }
}
