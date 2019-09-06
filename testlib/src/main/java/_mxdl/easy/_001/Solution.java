package _mxdl.easy._001;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Description: <两数求和找下标><br>
 * Author: mxdl<br>
 * Date: 2019/9/5<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class Solution {
  // 1.通过两次循环解决
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }
    return null;
  }

  // 2.借助HashMap
  public int[] twoSum1(int[] nums, int target) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int key = target - nums[i];
      if (hashMap.containsKey(key)) {
        return new int[] {hashMap.get(key),i};
      }
      hashMap.put(nums[i], i);//*****
    }
    return null;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = {4, 2, 8, 5, 7, 1, 3, 6};
    int[] result = solution.twoSum1(nums, 12);
    System.out.println(Arrays.toString(result));
  }
}
