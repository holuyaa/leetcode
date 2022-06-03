package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0153Test {

    private static final int[][] TESTCASES = new int[][]{
            {3,4,5,1,2},
            {4,5,6,7,0,1,2},
            {11,13,15,17},
            {2,3,4,5,1},
    };

    private static final int[] EXPECTED = new int[]{
            1,
            0,
            11,
            1,
    };

    @Test
    void findMin() {
        final Q0153 q = new Q0153();
        findMin(q::findMin);
    }

    private void findMin(ToIntFunction<int[]> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final int actual = func.applyAsInt(TESTCASES[i]);
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}