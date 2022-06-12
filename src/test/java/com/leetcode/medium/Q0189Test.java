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
    };

    private static final int[] STEPS = new int[]{
            3,
            2,
            2,
    };

    private static final int[][] EXPECTED = new int[][]{
            {5, 6, 7, 1, 2, 3, 4,},
            {3, 99, -1, -100},
            {-1},
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

    private void rotate(BiConsumer<int[], Integer> consumer) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final int[] actual = new int[TESTCASES[i].length];
            System.arraycopy(TESTCASES[i], 0, actual, 0, actual.length);
            consumer.accept(actual, STEPS[i]);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}