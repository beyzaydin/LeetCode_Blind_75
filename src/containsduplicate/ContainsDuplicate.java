package containsduplicate;

import java.util.*;

public class ContainsDuplicate {
    public boolean containsDuplicateFirst(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.get(num) == null)
                map.put(num, num);
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
        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(wrappedInts));
        return set.size() != nums.length;
    }
}
