package com.leetcode.etc;

public class LongestCommonSubstring {

    public String subString(String s, String t) {
        final int[][] l = new int[s.length()][t.length()];
        String max = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    if (i == 0 || j == 0) l[i][j] = 1;
                    else l[i][j] = l[i - 1][j - 1] + 1;
                    if (max.length() < l[i][j]) {
                        max = s.substring(i - l[i][j] + 1, i + 1);
                    }
                } else {
                    l[i][j] = 0;
                }
            }
        }
        return max;
    }
}
