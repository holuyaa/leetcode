package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q0017 {
    private static final char[][] TABLE = new char[][]{
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'},
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();
        final List<String> result = new ArrayList<>();
        letterCombinations(digits, 0, new char[digits.length()], result);
        return result;
    }

    private void letterCombinations(String digits, int pos, char[] buffer, List<String> result) {
        if (pos == digits.length()) {
            result.add(new String(buffer));
            return;
        }

        final int num = digits.charAt(pos) - '0';
        for (char c : TABLE[num]) {
            buffer[pos] = c;
            letterCombinations(digits, pos + 1, buffer, result);
        }
    }

    @SuppressWarnings("ConstantConditions")
    public List<String> letterCombinations1(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();
        final LinkedList<String> result = new LinkedList<>();
        result.offer("");
        while (result.peek().length() < digits.length()) {
            final String prefix = result.poll();
            for (char c : TABLE[digits.charAt(prefix.length()) - '0']) {
                result.offer(prefix + c);
            }
        }
        return result;
    }
}
