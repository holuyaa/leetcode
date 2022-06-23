package com.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Q0215 {
    public int findKthLargest(int[] numbers, int k) {
        Arrays.sort(numbers);
        return numbers[numbers.length - k];
    }

    public int findKthLargest1(int[] numbers, int k) {
        final Queue<Integer> queue = new PriorityQueue<>();
        for (int num : numbers) {
            queue.offer(num);
            if (queue.size() > k) queue.poll();
        }
        //noinspection ConstantConditions
        return queue.peek();
    }

    public int findKthLargest2(int[] numbers, int k) {
        return quickSelect(numbers, 0, numbers.length - 1, numbers.length - k);
    }

    private int quickSelect(int[] numbers, int left, int right, int k) {
        if (left == right) return numbers[k];
        final int p = partition(numbers, left, right);
        if (p < k) return quickSelect(numbers, p + 1, right, k);
        else if (k < p) return quickSelect(numbers, left, p - 1, k);
        return numbers[p];
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

    public int findKthLargest3(int[] numbers, int k) {
        k = numbers.length - k;
        int low = 0;
        int high = numbers.length - 1;

        while (low < high) {
            final int p = partition(numbers, low, high);
            if (p < k) low = p + 1;
            else if (k < p) high = p - 1;
            else break;
        }
        return numbers[k];
    }

    public int findKthLargest4(int[] numbers, int k) {
        shuffle(numbers);
        return findKthLargest3(numbers, k);
    }

    private void shuffle(int[] numbers) {
        final Random random = new Random();
        for(int i = 1; i < numbers.length; i++) {
            final int r = random.nextInt(i + 1);
            swap(numbers, i, r);
        }
    }

    public int findKthLargest5(int[] numbers, int k) {
        shuffle(numbers);
        k = numbers.length - k;
        int low = 0;
        int high = numbers.length - 1;

        while (low < high) {
            final int p = partition1(numbers, low, high);
            if (p < k) low = p + 1;
            else if (k < p) high = p - 1;
            else break;
        }
        return numbers[k];
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
}
