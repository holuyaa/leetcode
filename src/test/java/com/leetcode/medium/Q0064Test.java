package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0064Test {
    private static final int[][][] TESTCASES = new int[][][]{
            {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}},
            {{1, 2, 3}, {4, 5, 6}},
    };

    private static final int[] EXPECTED = new int[]{
            7,
            12,
    };

    @Test
    void minPathSum() {
        final Q0064 q = new Q0064();
        minPathSum(q::minPathSum);
    }

    private void minPathSum(ToIntFunction<int[][]> func) {
        for (int i = 0; i < TESTCASES.length; i += 2) {
            final int[][] tc = cloneArray(TESTCASES[i]);
            final int actual = func.applyAsInt(tc);
            assertEquals(EXPECTED[i], actual);
        }
    }

    private static int[][] cloneArray(int[][] src) {
        final int m = src.length;
        final int n = src[0].length;
        final int[][] target = new int[m][n];
        for (int i = 0; i < m; i++) System.arraycopy(src[i], 0, target[i], 0, n);
        return target;
    }
}