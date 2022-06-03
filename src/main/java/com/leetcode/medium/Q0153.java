package com.leetcode.medium;

public class Q0153 {
    public int findMin(int[] numbers) {
        if (numbers.length == 1) return numbers[0];

        int left = 0;
        int right = numbers.length - 1;

        if (numbers[left] < numbers[right]) return numbers[0];

        while (left <= right) {
            final int mid = (left + right) / 2;

            if (numbers[mid + 1] < numbers[mid]) return numbers[mid + 1];
            if (numbers[mid] < numbers[mid - 1]) return numbers[mid];
            if (numbers[left] < numbers[mid]) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }
}
