package com.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0136Test {

    private static final int[][] TESTCASES = new int[][]{
            {2, 2, 1},
            {4, 1, 2, 1, 2},
            {1},
    };

    private static final int[] EXPECTED = new int[]{
            1,
            4,
            1
    };

    @Test
    void singleNumber() {
        final Q0136 q = new Q0136();
        singleNumber(q::singleNumber);
    }

    @Test
    void singleNumber1() {
        final Q0136 q = new Q0136();
        singleNumber(q::singleNumber1);
    }

    @Test
    void singleNumber2() {
        final Q0136 q = new Q0136();
        singleNumber(q::singleNumber2);
    }

    private void singleNumber(ToIntFunction<int[]> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final int actual = func.applyAsInt(TESTCASES[i]);
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}