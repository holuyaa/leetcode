package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0128Test {

    private static final int[][] TESTCASES = new int[][]{
            {100, 4, 200, 1, 3, 2},
            {0, 3, 7, 2, 5, 8, 4, 6, 0, 1},
            {},
            {-4, -1, 4, -5, 1, -6, 9, -6, 0, 2, 2, 7, 0, 9, -3, 8, 9, -2, -6, 5, 0, 3, 4, -2},
    };

    private static final int[] EXPECTED = new int[]{
            4,
            9,
            0,
            12,
    };

    @Test
    void longestConsecutive() {
        final Q0128 q = new Q0128();
        longestConsecutive(q::longestConsecutive);
    }

    @Test
    void longestConsecutive1() {
        final Q0128 q = new Q0128();
        longestConsecutive(q::longestConsecutive1);
    }

    @Test
    void longestConsecutive2() {
        final Q0128 q = new Q0128();
        longestConsecutive(q::longestConsecutive2);
    }

    @Test
    void longestConsecutive3() {
        final Q0128 q = new Q0128();
        longestConsecutive(q::longestConsecutive3);
    }

    @Test
    void longestConsecutive4() {
        final Q0128 q = new Q0128();
        longestConsecutive(q::longestConsecutive4);
    }

    private void longestConsecutive(ToIntFunction<int[]> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final int[] tc = new int[TESTCASES[i].length];
            System.arraycopy(TESTCASES[i], 0, tc, 0, tc.length);
            final int actual = func.applyAsInt(tc);
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}