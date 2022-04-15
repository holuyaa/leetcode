package com.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0013Test {

    @Test
    void romanToInt() {
        final Q0013 q = new Q0013();
        final String[] testcases = new String[]{
                "III",
                "LVIII",
                "MCMXCIV"
        };
        final int[] expected = new int[]{
                3, 58, 1994
        };
        for (int i = 0; i < testcases.length; i++) {
            final int actual = q.romanToInt(testcases[i]);
            assertEquals(expected[i], actual);
            System.out.println(actual);
        }
    }
}