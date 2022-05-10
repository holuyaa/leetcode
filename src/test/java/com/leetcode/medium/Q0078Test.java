package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0078Test {
    private static final int[][] TESTCASES = new int[][]{
            {1, 2, 3},
            {0},
    };

    private static final List<List<List<Integer>>> EXPECTED = List.of(
            List.of(List.of(), List.of(1), List.of(2), List.of(1, 2), List.of(3), List.of(1, 3), List.of(2, 3), List.of(1, 2, 3)),
            List.of(List.of(), List.of(0))
    );

    @Test
    void subsets() {
        final Q0078 q = new Q0078();
        subsets(q::subsets);
    }

    @Test
    void subsets1() {
        final Q0078 q = new Q0078();
        subsets(q::subsets1);
    }

    @Test
    void subsets2() {
        final Q0078 q = new Q0078();
        subsets(q::subsets2);
    }

    private void subsets(Function<int[], List<List<Integer>>> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final List<List<Integer>> actual = func.apply(TESTCASES[i]);
            final List<List<Integer>> expected = new ArrayList<>(EXPECTED.get(i));
            assertListEquals(expected, actual);
        }
    }

    private void assertListEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
        expected.sort(Comparator.comparingInt((List<Integer> l) -> l.size()).thenComparing(Object::toString));
        actual.sort(Comparator.comparingInt((List<Integer> l) -> l.size()).thenComparing(Object::toString));
        assertEquals(expected, actual);
    }
}