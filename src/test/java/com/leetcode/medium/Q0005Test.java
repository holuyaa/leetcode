package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Q0005Test {
    private static final String[] TESTCASES = new String[]{
            "babad",
            "cbbd",
            "ba",
    };

    private static final String[][] EXPECTED = new String[][]{
            {"bab", "aba"},
            {"bb", "bb"},
            {"b", "b"}
    };

    @Test
    void longestPalindrome() {
        final Q0005 q = new Q0005();
        longestPalindrome(q::longestPalindrome);
    }

    private void longestPalindrome(Function<String, String> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final String actual = func.apply(TESTCASES[i]);
            System.out.println(actual);
            assertTrue(EXPECTED[i][0].equals(actual) || EXPECTED[i][1].equals(actual));
        }
    }

    @Test
    void longestPalindrome2() {
        final Q0005 q = new Q0005();
        longestPalindrome(q::longestPalindrome2);
    }

    @Test
    void longestPalindrome3() {
        final Q0005 q = new Q0005();
        longestPalindrome(q::longestPalindrome3);
    }
}