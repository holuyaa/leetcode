package com.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

class Q0242Test {
    private static final String[] TESTCASES = new String[]{
            "anagram",
            "nagaram",
            "rat",
            "car",
            "aacc",
            "ccac",
    };

    private static final boolean[] EXPECTED = new boolean[]{
            true,
            false,
            false,
    };

    @Test
    void isAnagram() {
        final Q0242 q = new Q0242();
        isAnagram(q::isAnagram);
    }

    @Test
    void isAnagram1() {
        final Q0242 q = new Q0242();
        isAnagram(q::isAnagram1);
    }

    private void isAnagram(BiFunction<String, String, Boolean> func) {
        for (int i = 0; i < TESTCASES.length; i += 2) {
            final boolean actual = func.apply(TESTCASES[i], TESTCASES[i + 1]);
            assertEquals(EXPECTED[i / 2], actual);
        }
    }
}