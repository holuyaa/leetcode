package com.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0035Test {
    private static final int[][] TESTCASES = new int[][]{
            {1, 3, 5, 6},
            {1, 3, 5, 6},
            {1, 3, 5, 6},
    };

    private static final int[] TARGETS = new int[]{
            5,
            2,
            7,
    };

    private static final int[] EXPECTED = new int[]{
            2,
            1,
            4,

    };

    @Test
    void searchInsert() {
        final Q0035 q = new Q0035();
        for (int i = 0; i < TESTCASES.length; i++) {
            final int actual = q.searchInsert(TESTCASES[i], TARGETS[i]);
            assertEquals(EXPECTED[i], actual);
        }
    }
}