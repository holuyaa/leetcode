package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q0131 {

    private final Map<String, Boolean> map = new HashMap<>();

    public List<List<String>> partition(String s) {
        map.clear();
        final List<List<String>> result = new ArrayList<>();
        partition(s, 0, result, new String[s.length()], 0);
        return result;
    }

    private void partition(String s, int start, List<List<String>> result, String[] array, int pos) {
        if (start == s.length()) {
            result.add(convertArrayToList(array));
            return;
        }
        for (int i = start + 1; i < s.length() + 1; i++) {
            final String sub = s.substring(start, i);
            if (!isPalindrome(sub)) continue;
            array[pos] = sub;
            partition(s, i, result, array, pos + 1);
            array[pos] = null;
        }
    }

    private boolean isPalindrome(String s) {
        if (map.containsKey(s)) return map.get(s);
        final int len = s.length();
        final char[] chars = s.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len - i - 1]) {
                map.put(s, false);
                return false;
            }
        }
        map.put(s, true);
        return true;
    }

    private List<String> convertArrayToList(String[] array) {
        final List<String> list = new ArrayList<>();
        for (String item : array) {
            if (item == null) break;
            list.add(item);
        }
        return list;
    }

    public List<List<String>> partition1(String s) {
        final int len = s.length();
        final List<List<String>> result = new ArrayList<>();
        partition1(s, 0, result, new String[s.length()], 0, new boolean[len][len]);
        return result;
    }

    private void partition1(String s, int start, List<List<String>> result, String[] array, int pos, boolean[][] dp) {
        if (start == s.length()) {
            result.add(convertArrayToList(array));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (s.charAt(end) == s.charAt(start) && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                final String sub = s.substring(start, end + 1);
                array[pos] = sub;
                partition1(s, end + 1, result, array, pos + 1, dp);
                array[pos] = null;
            }
        }
    }
}
