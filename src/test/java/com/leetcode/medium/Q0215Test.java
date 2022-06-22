package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.function.ToIntBiFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0215Test {

    private static final int[][] TESTCASES = new int[][]{
            {3, 2, 1, 5, 6, 4},
            {3, 2, 3, 1, 2, 4, 5, 5, 6},
    };

    private static final int[] K = new int[]{
            2,
            4,
    };

    private static final int[] EXPECTED = new int[]{
            5,
            4,
    };

    @Test
    void findKthLargest() {
        final Q0215 q = new Q0215();
        findKthLargest(q::findKthLargest);
    }

    @Test
    void findKthLargest1() {
        final Q0215 q = new Q0215();
        findKthLargest(q::findKthLargest1);
    }

    private void findKthLargest(ToIntBiFunction<int[], Integer> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final int[] tc = new int[TESTCASES[i].length];
            System.arraycopy(TESTCASES[i], 0, tc, 0, tc.length);
            final int actual = func.applyAsInt(tc, K[i]);
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}