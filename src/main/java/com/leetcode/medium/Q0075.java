package com.leetcode.medium;

import java.util.Arrays;

public class Q0075 {
    public void sortColors(int[] numbers) {
        final int[] counts = new int[3];
        for (int num : numbers) counts[num]++;
        int pos = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                numbers[pos++] = i;
            }
        }
    }

    public void sortColors1(int[] numbers) {
        final int[] counts = new int[3];
        for (int num : numbers) counts[num]++;
        int pos = 0;
        for (int i = 0; i < counts.length; i++) {
            Arrays.fill(numbers, pos, pos + counts[i], i);
            pos += counts[i];
        }
    }
}
