package C散列表.A006两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: <Test><br>
 * Author:      mxdl<br>
 * Date:        2021/2/27<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
class Test {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
