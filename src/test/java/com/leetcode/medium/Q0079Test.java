package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0079Test {
    private static final char[][][] TESTCASES = new char[][][]{
            {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
            {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
            {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}},
    };

    private static final String[] WORDS = new String[]{
            "ABCCED",
            "SEE",
            "ABCB",
    };

    private static final boolean[] EXPECTED = new boolean[]{
            true,
            true,
            false,
    };

    @Test
    void exist() {
        final Q0079 q = new Q0079();
        exist(q::exist);
    }

    @Test
    void exist1() {
        final Q0079 q = new Q0079();
        exist(q::exist1);
    }

    private void exist(BiFunction<char[][], String, Boolean> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final boolean actual = func.apply(TESTCASES[i], WORDS[i]);
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}