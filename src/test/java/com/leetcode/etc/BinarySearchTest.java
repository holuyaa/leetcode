package com.leetcode.etc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    private static final int[][] TESTCASES = new int[][]{
            {1,2,3,4,5,6,7,8,9},
            {-5,-4,-3,-2,-1,0,1,2,3,4,5},
            {1,2,3,4,5,6,7,8,9},
    };

    private static final int[] TARGETS = new int[]{
            4,
            3,
            10,
    };

    private static final int[] EXPECTED = new int[]{
            3,
            8,
            -10,
    };

    @Test
    void search() {
        final BinarySearch bs = new BinarySearch();
        for (int i = 0; i < TESTCASES.length; i++) {
            final int actual = bs.search(TESTCASES[i], TARGETS[i]);
            assertEquals(EXPECTED[i], actual);
        }
    }
}