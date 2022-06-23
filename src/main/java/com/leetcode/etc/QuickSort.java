package com.leetcode.etc;

public class QuickSort {
    public void sort(int[] numbers) {
        sort(numbers, 0, numbers.length - 1);
    }

    private void sort(int[] numbers, int left, int right) {
        if (right <= left) return;

        final int p = partition(numbers, left, right);
        sort(numbers, left, p - 1);
        sort(numbers, p + 1, right);
    }

    private int partition1(int[] numbers, int left, int right) {
        final int pivot = numbers[left];
        int low = left;
        int high = right;
        while (low < high) {
            while (pivot < numbers[high]) high--;
            while (low < high && numbers[low] <= pivot) low++;
            swap(numbers, low, high);
        }
        numbers[left] = numbers[low];
        numbers[low] = pivot;
        return low;
    }

    private int partition(int[] numbers, int left, int right) {
        final int pivot = numbers[right];
        int low = left;
        for (int high = left; high < right; high++) {
            if (pivot < numbers[high]) continue;
            swap(numbers, low, high);
            low++;
        }
        numbers[right] = numbers[low];
        numbers[low] = pivot;
        return low;
    }

    private void swap(int[] numbers, int a, int b) {
        final int tmp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = tmp;
    }
}
