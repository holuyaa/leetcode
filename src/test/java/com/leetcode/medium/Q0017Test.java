package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0017Test {
    private static final String[] TESTCASES = new String[]{
            "23",
            "",
            "2",
    };

    private static final List<List<String>> EXPECTED = List.of(
            List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"),
            Collections.emptyList(),
            List.of("a", "b", "c")

    );

    @Test
    void letterCombinations() {
        final Q0017 q = new Q0017();
        for (int i = 0; i < TESTCASES.length; i++) {
            final List<String> actual = q.letterCombinations(TESTCASES[i]);
            System.out.println(actual);
            assertListEquals(EXPECTED.get(i), actual);
        }
    }

    private void assertListEquals(List<String> expected, List<String> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
}