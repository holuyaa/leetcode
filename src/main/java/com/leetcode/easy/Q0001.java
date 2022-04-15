package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Q0001 {

    public int[] twoSumSimple(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{0, 0};
    }

    public int[] twoSum(int[] numbers, int target) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
               return new int[]{map.get(target - numbers[i]), i};
            }
            map.put(numbers[i], i);
        }
        return new int[]{0, 0};
    }
}