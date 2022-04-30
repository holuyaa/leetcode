package com.leetcode.medium;

import java.util.Arrays;

public class Q0045 {

    private static final int UNREACHABLE = Integer.MAX_VALUE >>> 1;

    public int jump(int[] numbers) {
        if (numbers.length < 2) return 0;
        final int[] distances = new int[numbers.length];
        Arrays.fill(distances, 1, distances.length, UNREACHABLE);
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j <= numbers[i] + i; j++) {
                distances[j] = Math.min(distances[i] + 1, distances[j]);
                if (j == numbers.length - 1) return distances[j];
            }
        }
        return 0;
    }

    public int jump1(int[] numbers) {
        if (numbers.length < 2) return 0;
        final int[] distances = new int[numbers.length];
        Arrays.fill(distances, 1, Math.min(numbers[0] + 1, numbers.length), 1);
        for (int i = 1; i < numbers.length - 1; i++) {
            for (int j = i + 1; j <= numbers[i] + i; j++) {
                distances[j] = distances[j] == 0 ? distances[i] + 1 : distances[j];
                if (j == numbers.length - 1) return distances[j];
            }
        }
        return distances[numbers.length - 1];
    }

    public int jump2(int[] numbers) {
        if (numbers.length < 2) return 0;
        int level = 0, left = 0, right = 0, max = 0;
        while (right < numbers.length - 1) {
            for (int i = left; i <= right; i++) max = Math.max(max, numbers[i] + i);
            left = right + 1;
            right = max;
            level++;
        }
        return level;
    }
}