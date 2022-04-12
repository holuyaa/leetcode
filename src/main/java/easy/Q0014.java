package easy;

import java.util.Arrays;

public class Q0014 {
    public static void main(String[] args) {
        final Q0014 q = new Q0014();
        for (String[] testcase : new String[][]{
                {"flower", "flower", "flower", "flower"},
                {"flower","flow","flight"},
                {"dog","racecar","car"},
                {"a"},
        }) {
            System.out.println(q.longestCommonPrefix(testcase));
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            final char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || c != strs[j].charAt(i)) return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
