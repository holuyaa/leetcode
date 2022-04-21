package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0013Test {
    private static final int[][] TESTCASES = new int[][]{
            {-1, 0, 1, 2, -1, -4},
            {},
            {0},
            {0, 0, 0, 0},
            {3, 0, -2, -1, 1, 2},
            {1, -1, -1, 0}
    };

    private static final List<List<List<Integer>>> EXPECTED = List.of(
            List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)),
            Collections.emptyList(),
            Collections.emptyList(),
            List.of(List.of(0, 0, 0)),
            List.of(List.of(-2, -1, 3), List.of(-2, 0, 2), List.of(-1, 0, 1)),
            List.of(List.of(-1, 0, 1))
    );

    @Test
    void threeSum() {
        final Q0013 q = new Q0013();
        threeSum(q::threeSum);
    }

    @Test
    void threeSum1() {
        final Q0013 q = new Q0013();
        threeSum(q::threeSum1);
    }

    private void threeSum(Function<int[], List<List<Integer>>> func) {
        final Q0013 q = new Q0013();
        for (int i = 0; i < TESTCASES.length; i++) {
            final List<List<Integer>> actual = func.apply(TESTCASES[i]);
            System.out.println(actual);
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