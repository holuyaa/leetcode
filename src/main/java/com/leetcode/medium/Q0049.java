package com.leetcode.medium;

import java.util.*;

public class Q0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> map = new HashMap<>();
        for (final String str : strs) {
            final char[] chars = str.toCharArray();
            Arrays.sort(chars);
            final String key = new String(chars);
            if (map.containsKey(key)) map.get(key).add(str);
            else {
                final List<String> value = new ArrayList<>();
                value.add(str);
                map.put(key, value);
            }
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        final Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            final char[] counts = new char[26];
            for (char c : str.toCharArray()) {
                counts[c - 'a']++;
            }
            final String key = new String(counts);
            final List<String> value = map.containsKey(key) ? map.get(key) : new ArrayList<>();
            value.add(str);
            map.put(key, value);
        }
        return new ArrayList<>(map.values());
    }
}
