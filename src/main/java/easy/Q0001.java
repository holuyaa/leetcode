package easy;

import java.util.HashMap;
import java.util.Map;

public class Q0001 {
    public static void main(String[] args) {
        Q0001 q = new Q0001();
        int[] ret = q.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("[" + ret[0] + ", " + ret[1] + "]");
        ret = q.twoSum(new int[]{2, 5, 5, 11}, 10);
        System.out.println("[" + ret[0] + ", " + ret[1] + "]");
    }

    /*
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{0, 0};
    }
     */
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