package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Q0169 {
    public int majorityElement(int[] numbers) {
        if (numbers.length == 1) return numbers[0];
        final int len = (numbers.length + 1) / 2;
        final Map<Integer, Integer> map = new HashMap<>();

        for (int num : numbers) {
            if (map.containsKey(num)) {
                final int count = map.get(num) + 1;
                if (len <= count) return num;
                map.put(num, count);
            } else map.put(num, 1);
        }
        return -1;
    }
}
