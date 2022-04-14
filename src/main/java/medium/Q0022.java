package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q0022 {

    public List<String> generateParenthesis(int n) {
        final List<String> list = new ArrayList<>();
        generate(list, "", 0, 0, n);
        return list;
    }

    private void generate(List<String> list, String str, int open, int close, int n) {
        if (open + close == n * 2) {
            list.add(str);
            return;
        }

        if (open < n) generate(list, str + '(', open + 1, close, n);
        if (close < open) generate(list, str + ')', open, close + 1, n);
    }

    public List<String> generateParenthesis2(int n) {
        final List<String> list = new ArrayList<>();
        final Set<String> visited = new HashSet<>();
        generate2(list, "", visited, n);
        return list;
    }

    private void generate2(List<String> list, String str, Set<String> visited, int n) {
        visited.add(str);

        if (str.length() == n * 2) {
            list.add(str);
            return;
        }

        if (!visited.contains("()" + str)) generate2(list, "()" + str, visited, n);
        if (!visited.contains("(" + str + ")")) generate2(list, "(" + str + ")", visited, n);
        if (!visited.contains(str + "()")) generate2(list, str + "()", visited, n);
    }

    public List<String> generateParenthesis3(int n) {
        final List<String> list = new ArrayList<>();
        generate3(list, new char[n * 2], 0, 0, n);
        return list;
    }

    private void generate3(List<String> list, char[] arr, int open, int close, int n) {
        if (open + close == n * 2) {
            list.add(new String(arr));
            return;
        }

        if (open < n) {
            arr[open + close] = '(';
            generate3(list, arr, open + 1, close, n);
        }
        if (close < open) {
            arr[open + close] = ')';
            generate3(list, arr, open, close + 1, n);
        }
    }

    public List<String> generateParenthesis4(int n) {
        final List<String> list = new ArrayList<>();
        generate4(new char[2 * n], 0, list);
        return list;
    }

    public void generate4(char[] arr, int pos, List<String> list) {
        if (pos == arr.length) {
            if (valid(arr)) list.add(new String(arr));
            return;
        }

        arr[pos] = '(';
        generate4(arr, pos + 1, list);

        arr[pos] = ')';
        generate4(arr, pos + 1, list);
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }

    public List<String> generateParenthesis5(int n) {
        final List<String> list = new ArrayList<>();
        if (n == 0) return list;
        if (n == 1) {
            list.add("()");
            return list;
        }
        final char[] arr = new char[n * 2];
        for (int val = 2; val < (1 << (n * 2)) - 1; val++) {
            generate5(list, arr, val, n);
        }
        return list;
    }

    private void generate5(List<String> list, char[] arr, int val, int n) {
        int pos = 0;
        int balance = 0;
        for (int i = 0; i < (n * 2); i++) {
            if ((val & 0x1) == 0x0) {
                balance++;
                arr[pos++] = '(';
                if (balance > n) return;
            } else {
                balance--;
                arr[pos++] = ')';
                if (balance < 0) return;
            }
            val = val >>> 1;
        }
        if (balance == 0) list.add(new String(arr));
    }
}
