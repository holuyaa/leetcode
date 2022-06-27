package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0221Test {

    private static final char[][][] TESTCASES = new char[][][]{
            {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}},
            {{'0', '1'}, {'1', '0'}},
            {{'0'}},
            {{'1', '1'}, {'1', '1'}},
    };

    private static final int[] EXPECTED = new int[]{
            4,
            1,
            0,
            4,
    };

    @Test
    void maximalSquare() {
        final Q0221 q = new Q0221();
        maximalSquare(q::maximalSquare);
    }

    @Test
    void maximalSquare1() {
        final Q0221 q = new Q0221();
        maximalSquare(q::maximalSquare1);
    }

    private void maximalSquare(ToIntFunction<char[][]> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final int actual = func.applyAsInt(TESTCASES[i]);
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}