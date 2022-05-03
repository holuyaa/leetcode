package com.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0053Test {

    private static final int[][] TESTCASES = new int[][]{
            {-2, 1, -3, 4, -1, 2, 1, -5, 4},
            {1},
            {5, 4, -1, 7, 8},
            {-1},
    };

    private static final int[] EXPECTED = new int[]{
            6,
            1,
            23,
            -1,
    };

    @Test
    void maxSubArray() {
        final Q0053 q = new Q0053();
        for (int i = 0; i < TESTCASES.length; i++) {
            final int actual = q.maxSubArray(TESTCASES[i]);
            System.out.println(actual);
            assertEquals(EXPECTED[i], actual);
        }
    }
}