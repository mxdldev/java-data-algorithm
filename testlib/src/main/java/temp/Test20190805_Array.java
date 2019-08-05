package temp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Description: <Test20190805_Array><br>
 * Author: mxdl<br>
 * Date: 2019/8/5<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class Test20190805_Array {
  // 1.冒泡排序
  public static int[] bubbleSort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = 0; j < nums.length - i - 1; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j + 1];
          nums[j + 1] = nums[j];
          nums[j] = temp;
        }
      }
    }
    return nums;
  }

  // 2.选择排序
  public static int[] selectSort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] > nums[j]) {
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
        }
      }
    }
    return nums;
  }

  // 3.桶排序
  public static int[] bucketSort(int[] nums, int max) {
    int[] arr = new int[max + 1];
    for (int i = 0; i < nums.length; i++) {
      arr[nums[i]]++;
    }
    return arr;
  }

  // 4.查找数组里面有没有重复元素
  public static boolean isHaveRepeat(int[] nums) {
    HashSet<Integer> hashSet = new HashSet();
    for (int i = 0; i < nums.length; i++) {
      if (hashSet.contains(nums[i])) {
        return true;
      }
      hashSet.add(nums[i]);
    }
    return false;
  }

  // 5.删除数据里面的重复元素
  public static int[] deleteRepeat(int[] nums) {
    loop: for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j]) {
          while (j < nums.length - 1) {
            nums[j] = nums[j + 1];
            j++;
          }
          nums = Arrays.copyOf(nums, nums.length - 1);
          i = -1;
          continue loop;
        }
      }
    }
    return nums;
  }

  // 6.两数求和找下标
  public static int[] searchSumIndex(int[] nums, int target) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int key = target - nums[i];
      if (hashMap.containsKey(key)) {
        return new int[] {hashMap.get(key), i};
      }
      hashMap.put(nums[i], i);
    }
    return null;
  }

  // 7.求左上到右下的路径数
  public static int getPath(int m, int n) {
    int[][] nums = new int[m][n];
    for (int i = 0; i < n; i++) {
      nums[0][i] = 1;
    }
    for (int i = 0; i < m; i++) {
      nums[i][0] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
      }
    }
    return nums[m - 1][n - 1];
  }

  // 8.求左上到右下的最小路径的和
  public static int getMinSum(int[][] nums) {
    int m = nums.length;
    int n = nums[0].length;
    int[][] arr = new int[m][n];
    arr[0][0] = nums[0][0];
    for (int i = 1; i < n; i++) {
      arr[0][i] = arr[0][i - 1] + nums[0][i];
    }
    for (int i = 1; i < m; i++) {
      arr[i][0] = arr[i-1][0] + nums[i][0];
    }
    for(int i = 1; i < m;i++){
      for(int j = 1; j < n;j++){
        arr[i][j] = Math.min(arr[i-1][j],arr[i][j-1]) + nums[i][j];
      }
    }
    return arr[m-1][n-1];
  }

  public static void main(String[] args) {
     int[][] nums = new int[][] {{2, 1}, {12, 2}};
    System.out.println(getMinSum(nums));
  }
}
