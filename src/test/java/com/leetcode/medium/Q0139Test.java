package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0139Test {

    private static final String[] TESTCASES = new String[]{
            "leetcode",
            "applepenapple",
            "catsandog",
            "aaaaaaa",
    };

    private static final List<List<String>> WORDDICT = List.of(
            List.of("leet", "code"),
            List.of("apple", "pen"),
            List.of("cats", "dog", "sand", "and", "cat"),
            List.of("aaaa","aaa")
    );

    private static final boolean[] EXPECTED = new boolean[]{
            true,
            true,
            false,
            true,
    };

    @Test
    void wordBreak() {
        final Q0139 q = new Q0139();
        for (int i = 0; i < TESTCASES.length; i++) {
            final boolean actual = q.wordBreak(TESTCASES[i], WORDDICT.get(i));
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}