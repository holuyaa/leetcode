package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Q0048Test {

    private static final int[][][] TESTCASES = new int[][][]{
            {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
            {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}},
    };

    private static final int[][][] EXPECTED = new int[][][]{
            {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}},
            {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}},
    };

    @Test
    void rotate() {
        final Q0048 q = new Q0048();
        rotate(q::rotate);
    }

    @Test
    void rotate1() {
        final Q0048 q = new Q0048();
        // transpose and then reflect
        rotate(q::rotate1);
    }

    @Test
    void rotate2() {
        final Q0048 q = new Q0048();
        // reflect and then transpose
        rotate(q::rotate2);
    }

    private void rotate(Consumer<int[][]> consumer) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final int[][] actual = make2DArray(TESTCASES[i]);
            consumer.accept(actual);
            assert2DArrayEquals(EXPECTED[i], actual);
        }
    }

    private int[][] make2DArray(int[][] matrix) {
        final int[][] actual = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, actual[i], 0, matrix.length);
        }
        return actual;
    }

    private void assert2DArrayEquals(int[][] expected, int[][] actual) {
        for (int i = 0; i < actual.length; i++) {
            System.out.println(Arrays.toString(actual[i]));
            assertArrayEquals(expected[i], actual[i]);
        }
    }
}