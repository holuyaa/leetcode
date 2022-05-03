package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0049Test {
    private static final String[][] TESTCASES = new String[][]{
            {"eat", "tea", "tan", "ate", "nat", "bat"},
            {""},
            {"a"},
    };

    private static final List<List<List<String>>> EXPECTED = List.of(
            List.of(List.of("bat"), List.of("nat", "tan"), List.of("ate", "eat", "tea")),
            List.of(List.of("")),
            List.of(List.of("a"))
    );

    @Test
    void groupAnagrams() {
        final Q0049 q = new Q0049();
        groupAnagrams(q::groupAnagrams);
    }

    @Test
    void groupAnagrams1() {
        final Q0049 q = new Q0049();
        groupAnagrams(q::groupAnagrams1);
    }

    private void groupAnagrams(Function<String[], List<List<String>>> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final List<List<String>> actual = func.apply(TESTCASES[i]);
            sort(actual);
            System.out.println(actual);
            assertEquals(EXPECTED.get(i), actual);
        }
    }

    private void sort(List<List<String>> list) {
        list.sort(Comparator.comparingInt((List<String> o) -> o.size()).thenComparing(o -> o.get(0)));
        for (List<String> item : list) {
            item.sort(Comparator.naturalOrder());
        }
    }
}