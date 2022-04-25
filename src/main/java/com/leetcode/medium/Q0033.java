package com.leetcode.medium;

public class Q0033 {
    public int search(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) >>> 1;
            final int lowVal = numbers[low];
            final int midVal = numbers[mid];
            final int highVal = numbers[high];
            if (lowVal == target) return low;
            else if (midVal == target) return mid;
            else if (highVal == target) return high;
            else if (midVal < target) {
                if (highVal < target && midVal < highVal) high = mid - 1;
                else low = mid + 1;
            } else {
                if (target < lowVal && lowVal < midVal) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}
