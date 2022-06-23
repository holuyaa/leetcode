package com.leetcode.etc;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class QuickSortTest {

    private static final int[][] TESTCASES = new int[][]{
            {5, 3, 8, 4, 9, 1, 6, 2, 7},
    };

    private static final int[][] EXPECTED = new int[][]{
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
    };

    @Test
    void sort() {
        final QuickSort qs = new QuickSort();
        for (int i = 0; i < TESTCASES.length; i++) {
            final int[] actual = new int[TESTCASES[i].length];
            System.arraycopy(TESTCASES[i], 0, actual, 0, actual.length);
            qs.sort(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}