package com.leetcode.etc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortTest {

    private static final int[][] TESTCASES = new int[][] {
            {3, 4, 1, 5, 2},
            {27, 10, 12, 20, 25, 13, 15, 22},
    };

    private static final int[][] EXPECTED = new int[][]{
            {1, 2, 3, 4, 5},
            {10, 12, 13, 15, 20, 22, 25, 27},
    };

    @Test
    void sort() {
        final MergeSort mergeSort = new MergeSort();
        for (int i = 0; i < TESTCASES.length; i++) {
            final int[] actual = mergeSort.sort(TESTCASES[i]);
            System.out.println(Arrays.toString(actual));
            assertArrayEquals(EXPECTED[i], actual);
        }
    }
}