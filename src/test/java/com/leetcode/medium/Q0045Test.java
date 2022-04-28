package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0045Test {

    private static final int[][] TESTCASES = new int[][]{
            {},
            {1},
            {1, 2},
            {2, 1},
            {2, 3, 1, 1, 4},
            {2, 3, 0, 1, 4},
    };

    private static final int[] EXPECTED = new int[]{
            0,
            0,
            1,
            1,
            2,
            2,
    };

    @Test
    void jump() {
        final Q0045 q = new Q0045();
        jump(q::jump);
    }

    @Test
    void jump1() {
        final Q0045 q = new Q0045();
        jump(q::jump1);
    }

    @Test
    void jump2() {
        final Q0045 q = new Q0045();
        jump(q::jump2);
    }

    private void jump(ToIntFunction<int[]> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final int actual = func.applyAsInt(TESTCASES[i]);
            System.out.println(actual);
            assertEquals(EXPECTED[i], actual);
        }
    }
}