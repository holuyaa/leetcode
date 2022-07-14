package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0238Test {

    private static final int[][] TESTCASES = new int[][]{
            {1, 2, 3, 4},
            {-1, 1, 0, -3, 3},
    };

    private static final int[][] EXPECTED = new int[][]{
            {24, 12, 8, 6},
            {0, 0, 9, 0, 0},
    };

    @Test
    void productExceptSelf() {
        final Q0238 q = new Q0238();
        productExceptSelf(q::productExceptSelf);
    }

    @Test
    void productExceptSelf1() {
        final Q0238 q = new Q0238();
        productExceptSelf(q::productExceptSelf1);
    }

    private void productExceptSelf(Function<int[], int[]> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final int[] actual = func.apply(TESTCASES[i]);
            System.out.println(Arrays.toString(actual));
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}