package com.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0121Test {

    private static final int[][] TESTCASES = new int[][]{
            {7,1,5,3,6,4},
            {7,6,4,3,1},
    };

    private static final int[] EXPECTED = new int[]{
           5,
           0,
    };

    @Test
    void maxProfit() {
        final Q0121 q = new Q0121();
        maxProfit(q::maxProfit);
    }

    @Test
    void maxProfit1() {
        final Q0121 q = new Q0121();
        maxProfit(q::maxProfit1);
    }

    @Test
    void maxProfit2() {
        final Q0121 q = new Q0121();
        maxProfit(q::maxProfit2);
    }

    private void maxProfit(ToIntFunction<int[]> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final int actual = func.applyAsInt(TESTCASES[i]);
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}