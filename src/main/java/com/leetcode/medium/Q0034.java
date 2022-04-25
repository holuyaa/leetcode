package com.leetcode.medium;

public class Q0034 {

    private static final int[] NO_FOUND = new int[]{-1, -1};

    public int[] searchRange(int[] numbers, int target) {
        if (numbers.length == 0) return NO_FOUND;
        final int start = binarySearch(numbers, target - 0.1);
        final int end = binarySearch(numbers, target + 0.1);
        if (end == start) return NO_FOUND;
        return new int[]{start, end - 1};
    }

    private int binarySearch(int[] numbers, double target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high) {
            final int mid = (low + high) >>> 1;
            final int midVal = numbers[mid];
            if (midVal < target) low = mid + 1;
            else if (target < midVal) high = mid - 1;
        }
        return low;
    }
}
