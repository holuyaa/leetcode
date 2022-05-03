package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0046Test {

    private static final int[][] TESTCASES = new int[][]{
            {1, 2, 3},
            {0, 1},
            {1},
    };

    private static final List<List<List<Integer>>> EXPECTED = List.of(
            List.of(List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3), List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1)),
            List.of(List.of(0, 1), List.of(1, 0)),
            List.of(List.of(1))
    );

    @Test
    void permute() {
        final Q0046 q = new Q0046();
        for (int i = 0; i < TESTCASES.length; i++) {
            final List<List<Integer>> actual = q.permute(TESTCASES[i]);
            System.out.println(actual);
            assertEquals(EXPECTED.get(i), actual);
        }
    }
}