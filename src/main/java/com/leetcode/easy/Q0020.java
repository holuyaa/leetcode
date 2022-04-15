package com.leetcode.easy;

import java.util.Stack;

public class Q0020 {

    public boolean isValid(String s) {
        final Stack<Character> stack = new Stack<>();
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
                    if (stack.empty() || stack.pop() != c) {
                        return false;
                    }
            }
        }

        return stack.isEmpty();
    }
}
