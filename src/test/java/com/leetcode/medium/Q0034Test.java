package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Q0034Test {
    private static final int[][] TESTCASES = new int[][]{
            {2, 2},
            {1},
            {1, 2},
            {5, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 10},
            {5, 7, 7, 8, 8, 10},
            {5, 7, 7, 8, 8, 10},
            {},
    };

    private static final int[] TARGETS = new int[]{
            1,
            1,
            2,
            7,
            8,
            6,
            0,
    };

    private static final int[][] EXPECTED = new int[][]{
            {-1, -1},
            {0, 0},
            {1, 1},
            {1, 7},
            {3, 4},
            {-1, -1},
            {-1, -1},
    };

    @Test
    void searchRange() {
        final Q0034 q = new Q0034();
        for (int i = 0; i < TESTCASES.length; i++) {
            final int[] actual = q.searchRange(TESTCASES[i], TARGETS[i]);
            assertArrayEquals(EXPECTED[i], actual);
        }
    }
}