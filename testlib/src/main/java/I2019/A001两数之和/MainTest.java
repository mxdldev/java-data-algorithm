package I2019.A001两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: <MainTest><br>
 * Author: mxdl<br>
 * Date: 2019/8/2<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainTest {

  public static void main(String[] args){
      int[] arr = {2,5,6,9,11};
      int[] ints = checkIndex(arr, 13);
      System.out.println(ints[0]+":"+ints[1]);
  }
    // 要求：输入一个数组和数组中任意两数的和值求下标
    /**
     * <h1>解题思路</h1>
     * <li>1.将数组元素和下标成对存入到哈希表</li>
     * <li>2.遍历数组，和值和数据元素求差并检查该值在哈希表中是否存在</li>
     *
     */
    public static int[] checkIndex(int[] nums, int target) {
        int[] result = null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if(map.containsKey(key)){
                result = new int[2];
                result[0] = i;
                result[1] = map.get(key);
                return result;
            }
        }
        return result;
    }

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
