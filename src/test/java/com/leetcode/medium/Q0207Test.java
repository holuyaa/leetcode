package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0207Test {

    private static final int[] NUM_COURSES = new int[]{
            2,
            2,
            2,
    };

    private static final int[][][] TESTCASES = new int[][][]{
            {{1, 0}},
            {{1, 0}, {0, 1}},
            {{0, 1}},
    };

    private static final boolean[] EXPECTED = new boolean[]{
            true,
            false,
            true,
    };

    @Test
    void canFinish() {
        final Q0207 q = new Q0207();
        canFinish(q::canFinish);
    }

    @Test
    void canFinish1() {
        final Q0207 q = new Q0207();
        canFinish(q::canFinish1);
    }

    private void canFinish(BiFunction<Integer, int[][], Boolean> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final boolean actual = func.apply(NUM_COURSES[i], TESTCASES[i]);
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}