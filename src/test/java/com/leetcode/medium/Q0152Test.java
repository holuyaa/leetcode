package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0152Test {

    private static final int[][] TESTCASES = new int[][]{
            {2, -5, -2, -4, 3},
            {2, 3, -2, 4},
            {-2, 0, -1},
            {2, 3, -2, -4},
            {-2},
            {0, 2},
    };

    private static final int[] EXPECTED = new int[]{
            24,
            6,
            0,
            48,
            -2,
            2,
    };

    @Test
    void maxProduct() {
        final Q0152 q = new Q0152();
        maxProduct(q::maxProduct);
    }

    @Test
    void maxProduct1() {
        final Q0152 q = new Q0152();
        maxProduct(q::maxProduct1);
    }

    private void maxProduct(ToIntFunction<int[]> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final int actual = func.applyAsInt(TESTCASES[i]);
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}