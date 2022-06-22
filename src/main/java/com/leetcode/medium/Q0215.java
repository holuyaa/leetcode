package com.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

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
}
