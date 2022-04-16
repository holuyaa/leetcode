package com.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q0003 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) return 1;
        final Map<Character, Integer> visited = new HashMap<>();
        int max = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            final char c = s.charAt(end);
            if (visited.containsKey(c)) {
                start = Math.max(start, visited.get(c) + 1);
            }
            visited.put(c, end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 1) return 1;
        final int[] visited = new int[256];
        Arrays.fill(visited, -1);
        int max = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            final char c = s.charAt(end);
            if (visited[c] > -1) {
                start = Math.max(start, visited[c] + 1);
            }
            visited[c] = end;
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
