package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0033Test {

    private static final int[] TARGETS = new int[]{
            0,
            3,
            0,
            1,
            8,
    };
    private static final int[] EXPECTED = new int[]{
            4,
            -1,
            -1,
            1,
            4,
    };
    private final int[][] TESTCASES = new int[][]{
            {4, 5, 6, 7, 0, 1, 2},
            {4, 5, 6, 7, 0, 1, 2},
            {1},
            {3, 1},
            {4, 5, 6, 7, 8, 0, 1, 2},
    };

    @Test
    void search() {
        final Q0033 q = new Q0033();
        for (int i = 0; i < TESTCASES.length; i++) {
            final int actual = q.search(TESTCASES[i], TARGETS[i]);
            assertEquals(EXPECTED[i], actual);
        }
    }
}