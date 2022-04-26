package com.leetcode.easy;

public class Q0035 {
    public int searchInsert(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            final int mid = (low + high) >>> 1;
            final int midVal = numbers[mid];
            if (midVal < target) low = mid + 1;
            else if (target < midVal) high = mid - 1;
            else return mid;
        }
        return low;
    }
}
