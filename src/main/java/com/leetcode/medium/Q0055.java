package com.leetcode.medium;

public class Q0055 {
    public boolean canJump(int[] numbers) {
        int left = 0, right = 0, max = 0;
        while (right < numbers.length - 1) {
            for (int i = left; i <= right; i++) max = Math.max(max, i + numbers[i]);
            left = right + 1;
            right = max;
            if (right < left) return false;
        }
        return true;
    }

    public boolean canJump1(int[] numbers) {
        int max = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (max < i) return false;
            max = Math.max(numbers[i] + i, max);
        }
        return true;
    }

    public boolean canJump2(int[] numbers) {
        int i = 0, max = 0;
        for (; i < numbers.length && i <= max; i++) {
            max = Math.max(numbers[i] + i, max);
        }
        return i == numbers.length;
    }
}
