package twossums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSums {

    public static int[] twoSumSecond(int[] nums, int target) {
        int lengt = nums.length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < lengt - 1; i++) {
            for (int j = i + 1; j < lengt; j++) {
                map.put(nums[i] + nums[j], new int[]{i, j});
            }
        }
        if (map.containsKey(target))
            return map.get(target);
        return null;
    }

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        //int min2 = Integer.MAX_VALUE;
        int max = 0;
        //int max2 = Integer.MIN_VALUE;
        int cursor = 0;
        int index = 0;

        for (var num : prices) {
            if (num < min) {
                //min2 = min;
                min = num;
                index = cursor;
            }
            cursor++;
        }

        for (int i = index + 1; i < prices.length; i++) {
            if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }

    public int[] twoSumFirst(int[] nums, int target) {
        int lengt = nums.length;
        for (int i = 0; i < lengt - 1; i++) {
            for (int j = i + 1; j < lengt; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return null;
    }
}
