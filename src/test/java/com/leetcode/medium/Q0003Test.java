package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0003Test {

    private static final String[] TESTCASES = new String[]{
            "abcabcbb",
            "bbbbb",
            "pwwkew",
            " ",
            "aa",
            "au",
            "abba",
    };

    private static final int[] EXPECTED = new int[]{
            3,
            1,
            3,
            1,
            1,
            2,
            2
    };

    @Test
    void lengthOfLongestSubstring() {
        final Q0003 q = new Q0003();
        lengthOfLongestSubstring(q::lengthOfLongestSubstring);
    }

    @Test
    void lengthOfLongestSubstring2() {
        final Q0003 q = new Q0003();
        lengthOfLongestSubstring(q::lengthOfLongestSubstring2);
    }

    private void lengthOfLongestSubstring(ToIntFunction<String> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final int actual = func.applyAsInt(TESTCASES[i]);
            assertEquals(EXPECTED[i], actual);
            System.out.println(actual);
        }
    }
}