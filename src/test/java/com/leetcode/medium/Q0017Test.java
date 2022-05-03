package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

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
        letterCombinations(q::letterCombinations);
    }

    @Test
    void letterCombinations1() {
        final Q0017 q = new Q0017();
        letterCombinations(q::letterCombinations1);
    }

    private void letterCombinations(Function<String, List<String>> func) {
        final Q0017 q = new Q0017();
        for (int i = 0; i < TESTCASES.length; i++) {
            final List<String> actual = func.apply(TESTCASES[i]);
            System.out.println(actual);
            assertEquals(EXPECTED.get(i), actual);
        }
    }
}