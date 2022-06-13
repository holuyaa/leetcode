package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0198Test {

    private static final int[][] TESTCASES = new int[][]{
            {1, 2, 3, 1},
            {2, 7, 9, 3, 1},
            {2, 1, 1, 2},
    };

    private static final int[] EXPECTED = new int[]{
            4,
            12,
            4,
    };

    @Test
    void rob() {
        final Q0198 q = new Q0198();
        for (int i = 0; i < TESTCASES.length; i++) {
            final int[] tc = new int[TESTCASES[i].length];
            System.arraycopy(TESTCASES[i], 0, tc, 0, tc.length);
            final int actual = q.rob(tc);
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}