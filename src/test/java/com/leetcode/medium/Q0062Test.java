package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

class Q0062Test {
    private static final int[] TESTCASES = new int[]{
            3,
            3,
            4,
            4,
            3,
            7,
            3,
            2,
            1,
            1,
            10,
            10,
    };

    private static final int[] EXPECTED = new int[]{
            6,
            20,
            28,
            3,
            1,
            48620,
    };

    @Test
    void uniquePaths() {
        final Q0062 q = new Q0062();
        uniquePaths(q::uniquePaths);
    }

    @Test
    void uniquePaths1() {
        final Q0062 q = new Q0062();
        uniquePaths(q::uniquePaths1);
    }

    @Test
    void uniquePaths2() {
        final Q0062 q = new Q0062();
        uniquePaths(q::uniquePaths2);
    }

    private void uniquePaths(BiFunction<Integer, Integer, Integer> func) {
        for (int i = 0; i < TESTCASES.length; i += 2) {
            final int actual = func.apply(TESTCASES[i], TESTCASES[i + 1]);
            assertEquals(EXPECTED[i / 2], actual);
        }
    }
}