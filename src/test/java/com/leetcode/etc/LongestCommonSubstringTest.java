package com.leetcode.etc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonSubstringTest {
    private static final String[] TESTCASES = new String[]{
            "abcdef",
            "abadef",
    };

    private static final String[] EXPECTED = new String[]{
            "def",
    };

    @Test
    void subString() {
        final LongestCommonSubstring lcs = new LongestCommonSubstring();
        for (int i = 0; i < TESTCASES.length; i += 2) {
            final String actual = lcs.subString(TESTCASES[i], TESTCASES[i + 1]);
            System.out.println(actual);
            assertEquals(EXPECTED[i], actual);
        }
    }
}