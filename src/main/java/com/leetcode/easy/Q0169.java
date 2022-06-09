package com.leetcode.easy;

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

    public int majorityElement2(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length / 2];
    }

    /**
     * Boyer-Moore voting
     */
    public int majorityElement3(int[] numbers) {
        int count = 0;
        int major = 0;
        for (int num : numbers) {
            if (count == 0) major = num;
            if (num == major) count++;
            else count--;
        }
        return major;
    }

    public int majorityElement4(int[] numbers) {
        final int[] bit = new int[32];
        for (int num : numbers) {
            for (int i = 0; i < 32; i++) {
                if ((num >> (31 - i) & 1) == 1) bit[i]++;
            }
        }
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            bit[i] = bit[i] > numbers.length / 2 ? 1 : 0;
            ret += bit[i] * (1 << (31 - i));
        }
        return ret;
    }
}
