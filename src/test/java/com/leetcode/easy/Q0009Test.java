package com.leetcode.easy;

import com.leetcode.easy.Q0009;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q0009Test {

    @Test
    void isPalindrome() {
        final Q0009 q = new Q0009();
        final int[] testcases = new int[]{
                121, -121, 10, 100, 101
        };
        final boolean[] expected = new boolean[]{
                true, false, false, false, true
        };
        for (int i = 0; i < testcases.length; i++) {
            final boolean actual = q.isPalindrome(testcases[i]);
            assertEquals(expected[i], actual);
            System.out.println(actual);
        }
    }
}