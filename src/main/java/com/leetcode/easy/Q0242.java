package com.leetcode.easy;

import java.util.Arrays;

public class Q0242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        final char[] arr1 = s.toCharArray();
        final char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        final int[] used = new int['z' - 'a' + 1];
        for (char c : s.toCharArray()) used[c - 'a']++;
        for (char c : t.toCharArray()) if (used[c - 'a']-- == 0) return false;
        return true;
    }
}
