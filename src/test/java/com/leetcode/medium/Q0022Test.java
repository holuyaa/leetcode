package com.leetcode.medium;

import com.leetcode.medium.Q0022;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Q0022Test {

    private static final int[] TESTCASES = new int[]{
            3, 1, 2
    };

    private static final String[][] EXPECTED = new String[][]{
            {"((()))", "(()())", "(())()", "()(())", "()()()"},
            {"()"},
            {"(())", "()()"}
    };

    @Test
    void generateParenthesis() {
        final Q0022 q = new Q0022();
        generateParenthesis(q::generateParenthesis);
    }

    @Test
    void generateParenthesis2() {
        final Q0022 q = new Q0022();
        generateParenthesis(q::generateParenthesis2);
    }

    @Test
    void generateParenthesis3() {
        final Q0022 q = new Q0022();
        generateParenthesis(q::generateParenthesis3);
    }

    @Test
    void generateParenthesis4() {
        final Q0022 q = new Q0022();
        generateParenthesis(q::generateParenthesis4);
    }

    @Test
    void generateParenthesis5() {
        final Q0022 q = new Q0022();
        generateParenthesis(q::generateParenthesis5);
    }

    private void generateParenthesis(IntFunction<List<String>> func) {
        final Q0022 q = new Q0022();
        for (int i = 0; i < TESTCASES.length; i++) {
            final String[] actual = func.apply(TESTCASES[i]).toArray(new String[0]);
            Arrays.sort(actual);
            assertArrayEquals(EXPECTED[i], actual);
            System.out.println(Arrays.toString(actual));
        }
    }
}