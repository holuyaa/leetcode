package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Q0056Test {
    private static final int[][][] TESTCASES = new int[][][]{
            {{1, 3}, {2, 6}, {8, 10}, {15, 18}},
            {{1, 4}, {4, 5}},
            {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}},
    };

    private static final int[][][] EXPECTED = new int[][][]{
            {{1, 6}, {8, 10}, {15, 18}},
            {{1, 5}},
            {{1, 10}},
    };

    @Test
    void merge() {
        final Q0056 q = new Q0056();
        merge(q::merge);
    }

    @Test
    void merge1() {
        final Q0056 q = new Q0056();
        merge(q::merge1);
    }

    @Test
    void merge2() {
        final Q0056 q = new Q0056();
        merge(q::merge2);
    }

    @Test
    void merge3() {
        final Q0056 q = new Q0056();
        merge(q::merge3);
    }

    private void merge(Function<int[][], int[][]> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final int[][] actual = func.apply(TESTCASES[i]);
            for (int[] ints : actual) {
                System.out.println(Arrays.toString(ints));
            }
            assertArrayEquals(EXPECTED[i], actual);
        }
    }
}