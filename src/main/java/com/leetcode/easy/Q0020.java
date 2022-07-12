package com.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q0020 {

    public boolean isValid(String s) {
        final Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
            }
        }

        return stack.isEmpty();
    }
}
