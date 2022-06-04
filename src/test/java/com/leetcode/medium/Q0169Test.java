package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0169Test {

    private static final int[][] TESTCASES = new int[][]{
            {3, 2, 3},
            {2, 2, 1, 1, 1, 2, 2},
            {1},
    };

    private static final int[] EXPECTED = new int[]{
            3,
            2,
            1,
    };

    @Test
    void majorityElement() {
        final Q0169 q = new Q0169();
        for (int i = 0; i < TESTCASES.length; i++) {
            final int actual = q.majorityElement(TESTCASES[i]);
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}