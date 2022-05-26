package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0131Test {

    private static final String[] TESTCASES = new String[]{
            "aab",
            "a",
    };

    private static final List<List<List<String>>> EXPECTED = List.of(
            List.of(List.of("a","a","b"), List.of("aa","b")),
            List.of(List.of("a"))
    );

    @Test
    void partition() {
        final Q0131 q = new Q0131();
        partition(q::partition);
    }

    @Test
    void partition1() {
        final Q0131 q = new Q0131();
        partition(q::partition1);
    }

    private void partition(Function<String, List<List<String>>> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final List<List<String>> actual = func.apply(TESTCASES[i]);
            System.out.println(actual);
            assertEquals(EXPECTED.get(i), actual);
        }
    }
}