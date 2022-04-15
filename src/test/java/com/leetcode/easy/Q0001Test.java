package com.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0001Test {
    private static final int[][] TESTCASES = new int[][]{
            {2, 7, 11, 15},
            {2, 5, 5, 11},
            {3, 2, 4},
            {3, 3}
    };

    private static final int[] TARGETS = new int[]{
            9,
            10,
            6,
            6
    };

    private static final int[][] EXPECTED = new int[][]{
            {0, 1},
            {1, 2},
            {1, 2},
            {0, 1}
    };

    @Test
    void twoSumSimple() {
        final Q0001 q = new Q0001();
        twoSum(q::twoSumSimple);
    }

    @Test
    void twoSum() {
        final Q0001 q = new Q0001();
        twoSum(q::twoSum);
    }

    private void twoSum(TestFunction func) {
        final Q0001 q = new Q0001();
        for (int i = 0; i < TESTCASES.length; i++) {
            final int[] actual = func.apply(TESTCASES[i], TARGETS[i]);
            assertEquals(EXPECTED[i][0], actual[0]);
            assertEquals(EXPECTED[i][1], actual[1]);
            System.out.println("[" + actual[0] + ", " + actual[1] + "]");
        }
    }

    private interface TestFunction {
        int[] apply(int[] numbers, int target);
    }
}