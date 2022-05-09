package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0074Test {
    private static final int[][][] TESTCASES = new int[][][]{
            {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}},
            {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}},
    };

    private static final int[] TARGETS = new int[]{
            3,
            13,
    };

    private static final boolean[] EXPECTED = new boolean[]{
            true,
            false,
    };

    @Test
    void searchMatrix() {
        final Q0074 q = new Q0074();
        searchMatrix(q::searchMatrix);
    }

    @Test
    void searchMatrix1() {
        final Q0074 q = new Q0074();
        searchMatrix(q::searchMatrix1);
    }

    private void searchMatrix(BiFunction<int[][], Integer, Boolean> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final boolean actual = func.apply(TESTCASES[i], TARGETS[i]);
            System.out.println(actual);
            assertEquals(EXPECTED[i], actual);
        }
    }
}