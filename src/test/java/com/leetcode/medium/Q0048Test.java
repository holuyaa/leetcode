package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Q0048Test {

    private static final int[][][] TESTCASES = new int[][][]{
            {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
            {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}},
    };

    private static final int[][][] EXPECTED = new int[][][]{
            {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}},
            {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}},
    };

    @Test
    void rotate() {
        final Q0048 q = new Q0048();
        for (int i = 0; i < TESTCASES.length; i++) {
            q.rotate(TESTCASES[i]);
            for (int j = 0; j < TESTCASES[i].length; j++) {
                System.out.println(Arrays.toString(TESTCASES[i][j]));
                assertArrayEquals(EXPECTED[i][j], TESTCASES[i][j]);
            }
        }
    }
}