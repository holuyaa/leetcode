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
        int step = 0, currentMax = 0, i = 0, nextMax = 0;
        while (currentMax - i + 1 > 0) {
            step++;
            for (; i <= currentMax; i++) {
                nextMax = Math.max(nextMax, numbers[i] + i);
                if (nextMax >= numbers.length - 1)
                    return step;
            }
            currentMax = nextMax;
        }
        return 0;
    }

    public int jump3(int[] numbers) {
        int jumps = 0, farthest = 0;
        int left = 0, right = 0;
        while (right < numbers.length - 1) {
            for (int i = left; i <= right; ++i)
                farthest = Math.max(farthest, i + numbers[i]);
            left = right + 1;
            right = farthest;
            ++jumps;
        }
        return jumps;
    }
}
