package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0096Test {

    private static final int[] TESTCASES = new int[]{
            1,
            2,
            3,
            4,
            5,
            6,
    };

    private static final int[] EXPECTED = new int[]{
            1,
            2,
            5,
            14,
            42,
            132,

    };

    @Test
    void numTrees() {
        final Q0096 q = new Q0096();
        for (int i = 0; i < TESTCASES.length; i++) {
            final int actual = q.numTrees(TESTCASES[i]);
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}