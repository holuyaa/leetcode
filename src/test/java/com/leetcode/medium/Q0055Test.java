package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0055Test {

    private static final int[][] TESTCASES = new int[][]{
            {2, 3, 1, 1, 4},
            {3, 2, 1, 0, 4},
            {0},
            {1, 2},
    };

    private static final boolean[] EXPECTED = new boolean[]{
            true,
            false,
            true,
            true,
    };

    @Test
    void canJump() {
        final Q0055 q = new Q0055();
        canJump(q::canJump);
    }

    @Test
    void canJump1() {
        final Q0055 q = new Q0055();
        canJump(q::canJump1);
    }

    @Test
    void canJump2() {
        final Q0055 q = new Q0055();
        canJump(q::canJump2);
    }

    void canJump(Function<int[], Boolean> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final boolean actual = func.apply(TESTCASES[i]);
            assertEquals(EXPECTED[i], actual);
        }
    }
}