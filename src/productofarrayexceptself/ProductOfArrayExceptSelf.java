package productofarrayexceptself;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelfFirst(int[] nums) {
        int multiply = Arrays.stream(nums).filter(value -> value != 0).reduce(1, (a, b) -> a * b);
        long zeroCount = Arrays.stream(nums).filter(value -> value == 0).count();
        return Arrays.stream(nums).map(element -> {
            if (zeroCount > 1) {
                return 0;
            } else if (zeroCount > 0 && element == 0) {
                return multiply;
            } else if (zeroCount > 0)
                return 0;
            return multiply / element;
        }).toArray();
    }

    public int[] productExceptSelfSecond(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int i, temp = 1;
        int prod[] = new int[nums.length];

        for (int j = 0; j < nums.length; j++)
            prod[j] = 1;
        for (i = 0; i < nums.length; i++) {
            prod[i] = temp;
            temp *= nums[i];
        }
        temp = 1;

        for (i = nums.length - 1; i >= 0; i--) {
            prod[i] *= temp;
            temp *= nums[i];
        }
        return prod;
    }
}
