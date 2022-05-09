package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Q0075Test {
    private static final int[][] TESTCASES = new int[][]{
            {2, 0, 2, 1, 1, 0},
            {2, 0, 1},
    };

    private static final int[][] EXPECTED = new int[][]{
            {0, 0, 1, 1, 2, 2},
            {0, 1, 2},
    };

    @Test
    void sortColors() {
        final Q0075 q = new Q0075();
        sortColors(q::sortColors);
    }

    @Test
    void sortColors1() {
        final Q0075 q = new Q0075();
        sortColors(q::sortColors1);
    }

    private void sortColors(Consumer<int[]> consumer) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final int[] actual = new int[TESTCASES[i].length];
            System.arraycopy(TESTCASES[i], 0, actual, 0, TESTCASES[i].length);
            consumer.accept(actual);
            System.out.println(Arrays.toString(actual));
            assertArrayEquals(EXPECTED[i], actual);
        }
    }
}