package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0039Test {

    private static final int[][] TESTCASES = new int[][]{
            {2, 3, 6, 7},
            {2, 3, 5},
            {2},
    };

    private static final int[] TARGETS = new int[]{
            7,
            8,
            1,
    };

    private static final List<List<List<Integer>>> EXPECTED = List.of(
            List.of(List.of(2, 2, 3), List.of(7)),
            List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5)),
            Collections.emptyList()
    );

    @Test
    void combinationSum() {
        final Q0039 q = new Q0039();
        for (int i = 0; i < TESTCASES.length; i++) {
            final List<List<Integer>> actual = q.combinationSum(TESTCASES[i], TARGETS[i]);
            assertListEquals(EXPECTED.get(i), actual);
        }
    }

    private void assertListEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
}