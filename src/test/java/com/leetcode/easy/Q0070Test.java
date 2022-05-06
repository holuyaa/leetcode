package com.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0070Test {
    private static final int[] TESTCASES = new int[]{
            2,
            3,
            4,
            5,
            6,
    };

    private static final int[] EXPECTED = new int[]{
            2,
            3,
            5,
            8,
            13
    };

    @Test
    void climbStairs() {
        final Q0070 q = new Q0070();
        climbStairs(q::climbStairs);
    }

    @Test
    void climbStairs1() {
        final Q0070 q = new Q0070();
        climbStairs(q::climbStairs1);
    }

    private void climbStairs(ToIntFunction<Integer> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final int actual = func.applyAsInt(TESTCASES[i]);
            System.out.println(actual);
            assertEquals(EXPECTED[i], actual);
        }
    }
}