package com.leetcode.etc;

public class BinarySearch {
    public int search(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high) {
            final int mid = (low + high) / 2;
            if (target < numbers[mid]) {
                high = mid - 1;
            } else if (target > numbers[mid]){
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }
}
