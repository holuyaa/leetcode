package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0200Test {

    private static final char[][][] TESTCASES = new char[][][]{
            {
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '0', '1', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '0', '0', '0'}
            },
            {
                    {'1', '1', '0', '0', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '1', '0', '0'},
                    {'0', '0', '0', '1', '1'}
            },
            {
                    {'1', '1', '1'},
                    {'0', '1', '0'},
                    {'1', '1', '1'}
            }
    };

    private static final int[] EXPECTED = new int[]{
            1,
            3,
            1,
    };

    @Test
    void numIslands() {
        final Q0200 q = new Q0200();
        for (int i = 0; i < TESTCASES.length; i++) {
            final int actual = q.numIslands(TESTCASES[i]);
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}