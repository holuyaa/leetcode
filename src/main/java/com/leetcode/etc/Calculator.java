package com.leetcode.etc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Calculator {

    public double calculate(String formula) {
        final List<String> postfix = new ArrayList<>();
        final Deque<String> stack = new ArrayDeque<>();

        int i = 0;
        while (i < formula.length()) {
            final char c = formula.charAt(i);
            if ('0' <= c && c <= '9') {
                int start = i;
                while (i < formula.length() && formula.charAt(i) != ' ') i++;
                postfix.add(formula.substring(start, i));
                continue;
            }

            switch (c) {
                case '(':
                    stack.push(c + "");
                    i += 2;
                    break;
                case ')':
                    while (!stack.isEmpty()) {
                        final String op = stack.pop();
                        if ("(".equals(op)) break;
                        postfix.add(op);
                    }
                    i += 2;
                    break;
                case '*':
                case '/':
                case '+':
                case '-':
                    if (stack.isEmpty()) stack.push(c + "");
                    else if (getOpOrder(stack.peek()) < getOpOrder(c + "")) stack.push(c + "");
                    else {
                        postfix.add(stack.pop());
                        stack.push(c + "");
                    }
                    i += 2;
                    break;
                default:
                    i++;
            }
        }

        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }

        for (String item : postfix) {
            double res;
            switch (item) {
                case "+":
                    res = Double.parseDouble(stack.pop()) + Double.parseDouble(stack.pop());
                    stack.push(res + "");
                    break;
                case "-":
                    res = Double.parseDouble(stack.pop()) - Double.parseDouble(stack.pop());
                    stack.push(res + "");
                    break;
                case "*":
                    res = Double.parseDouble(stack.pop()) * Double.parseDouble(stack.pop());
                    stack.push(res + "");
                    break;
                case "/":
                    res = Double.parseDouble(stack.pop()) / Double.parseDouble(stack.pop());
                    stack.push(res + "");
                    break;
                default:
                    stack.push(item);
            }
        }

        return Double.parseDouble(stack.pop());
    }

    private int getOpOrder(String op) {
        switch (op) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }
}
