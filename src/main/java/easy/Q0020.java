package easy;

import java.util.Stack;

public class Q0020 {

    public static void main(String[] args) {
        Q0020 q = new Q0020();
        for (String s : new String[]{
                "()",
                "()[]{}",
                "(]",
                "{{}[][[[]]]}",
                "[",
                "]"

        }) {
            System.out.println(q.isValid(s));
        }
    }

    public boolean isValid(String s) {
        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.empty() || Math.abs(c - stack.peek()) > 2) {
                        return false;
                    }
                    stack.pop();
                    break;
            }
        }

        return stack.empty();
    }
}
