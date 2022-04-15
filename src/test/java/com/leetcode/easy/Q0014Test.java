package com.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0014Test {

    @Test
    void longestCommonPrefix() {
        final Q0014 q = new Q0014();
        final String[][] testcases = new String[][]{
                {"flower", "flower", "flower", "flower"},
                {"flower","flow","flight"},
                {"dog","racecar","car"},
                {"a"},
        };
        final String[] expected = new String[]{
                "flower", "fl", "", "a"
        };
        for (int i = 0; i < testcases.length; i++) {
            final String actual = q.longestCommonPrefix(testcases[i]);
            assertEquals(expected[i], actual);
            System.out.println(actual);
        }
    }
}