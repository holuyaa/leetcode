package com.leetcode.medium;

import java.util.Arrays;
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

    public int majorityElement1(int[] numbers) {
        final int len = (numbers.length + 1) / 2;
        Arrays.sort(numbers);

        int count = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] == numbers[i]) {
                if (len <= ++count) return numbers[i];
            } else count = 1;
        }

        return 1;
    }
}
