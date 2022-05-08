package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Q0073Test {

    private static final int[][][] TESTCASES = new int[][][]{
            {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}},
            {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}},
            {{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}},
            {{1, 0, 3}},
            {{3, 5, 5, 6, 9, 1, 4, 5, 0, 5}, {2, 7, 9, 5, 9, 5, 4, 9, 6, 8}, {6, 0, 7, 8, 1, 0, 1, 6, 8, 1}, {7, 2, 6, 5, 8, 5, 6, 5, 0, 6}, {2, 3, 3, 1, 0, 4, 6, 5, 3, 5}, {5, 9, 7, 3, 8, 8, 5, 1, 4, 3}, {2, 4, 7, 9, 9, 8, 4, 7, 3, 7}, {3, 5, 2, 8, 8, 2, 2, 4, 9, 8}},
    };

    private static final int[][][] EXPECTED = new int[][][]{
            {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}},
            {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}},
            {{0, 0, 3, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}},
            {{0, 0, 0}},
            {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {2, 0, 9, 5, 0, 0, 4, 9, 0, 8}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {5, 0, 7, 3, 0, 0, 5, 1, 0, 3}, {2, 0, 7, 9, 0, 0, 4, 7, 0, 7}, {3, 0, 2, 8, 0, 0, 2, 4, 0, 8}}
    };

    private static int[][] cloneArray(int[][] src) {
        final int m = src.length;
        final int n = src[0].length;
        final int[][] target = new int[m][n];
        for (int i = 0; i < m; i++) System.arraycopy(src[i], 0, target[i], 0, n);
        return target;
    }

    @Test
    void setZeroes() {
        final Q0073 q = new Q0073();
        setZeroes(q::setZeroes);
    }

    @Test
    void setZeroes1() {
        final Q0073 q = new Q0073();
        setZeroes(q::setZeroes1);
    }

    private void setZeroes(Consumer<int[][]> consumer) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final int[][] actual = cloneArray(TESTCASES[i]);
            consumer.accept(actual);
            for (int[] ints : actual) {
                System.out.println(Arrays.toString(ints));
            }
            assertArrayEquals(EXPECTED[i], actual);
        }
    }
}