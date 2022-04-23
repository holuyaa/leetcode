package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Q0031Test {
    private static final int[][] TESTCASES = new int[][]{
            {1, 5, 8, 4, 7, 6, 5, 3, 1},
            {1, 2, 3},
            {3, 2, 1},
            {1, 1, 5},
    };

    private static final int[][] EXPECTED = new int[][]{
            {1, 5, 8, 5, 1, 3, 4, 6, 7},
            {1, 3, 2},
            {1, 2, 3},
            {1, 5, 1}
    };

    @Test
    void nextPermutation() {
        final Q0031 q = new Q0031();
        for (int i = 0; i < TESTCASES.length; i++) {
            final int[] actual = new int[TESTCASES[i].length];
            System.arraycopy(TESTCASES[i], 0, actual, 0, TESTCASES[i].length);
            q.nextPermutation(actual);
            System.out.println(Arrays.toString(actual));
            assertArrayEquals(EXPECTED[i], actual);
        }
    }
}