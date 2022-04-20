package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

import static org.junit.jupiter.api.Assertions.*;

class Q0011Test {
    private static final int[][] TESTCASES = new int[][]{
            {1, 8, 6, 2, 5, 4, 8, 3, 7},
            {1, 1},
    };

    private static final int[] EXPECTED = new int[]{
            49,
            1,
    };

    @Test
    void maxArea() {
        final Q0011 q = new Q0011();
        maxArea(q::maxArea);
    }

    @Test
    void maxArea1() {
        final Q0011 q = new Q0011();
        maxArea(q::maxArea1);
    }

    private void maxArea(ToIntFunction<int[]> func) {
        final Q0011 q = new Q0011();
        for (int i = 0; i < TESTCASES.length; i++) {
            final int actual = func.applyAsInt(TESTCASES[i]);
            System.out.println(actual);
            assertEquals(EXPECTED[i], actual);
        }
    }

}