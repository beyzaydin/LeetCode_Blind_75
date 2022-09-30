package containsduplicate;

import java.util.*;

public class ContainsDuplicate {
    public boolean containsDuplicateFirst(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == null)
                map.put(nums[i], nums[i]);
            else return true;
        }
        return false;
    }

    public boolean containsDuplicateSecond(int[] nums) {
        return Arrays.stream(nums).distinct().count() != nums.length;
    }

    public boolean containsDuplicateThree(int[] nums) {
        Integer[] wrappedInts = Arrays.stream(nums)
                .boxed()
                .toArray(Integer[]::new);
        TreeSet set = new TreeSet<Integer>(Arrays.asList(wrappedInts));
        if (set.size() != nums.length) {
            return true;
        } else {
            return false;
        }
    }
}
