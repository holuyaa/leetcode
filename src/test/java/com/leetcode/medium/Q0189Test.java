package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0189Test {

    private static final int[][] TESTCASES = new int[][]{
            {1, 2, 3, 4, 5, 6, 7},
            {-1, -100, 3, 99},
            {-1},
            {1, 2, 3, 4, 5, 6},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54},
    };

    private static final int[] STEPS = new int[]{
            3,
            2,
            2,
            4,
            45,
    };

    private static final int[][] EXPECTED = new int[][]{
            {5, 6, 7, 1, 2, 3, 4,},
            {3, 99, -1, -100},
            {-1},
            {3, 4, 5, 6, 1, 2},
            {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 1, 2, 3, 4, 5, 6, 7, 8, 9},
    };


    @Test
    void rotate() {
        final Q0189 q = new Q0189();
        rotate(q::rotate);
    }

    @Test
    void rotate1() {
        final Q0189 q = new Q0189();
        rotate(q::rotate1);
    }

    @Test
    void rotate2() {
        final Q0189 q = new Q0189();
        rotate(q::rotate2);
    }

    private void rotate(BiConsumer<int[], Integer> consumer) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final int[] actual = new int[TESTCASES[i].length];
            System.arraycopy(TESTCASES[i], 0, actual, 0, actual.length);
            consumer.accept(actual, STEPS[i]);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}