package I2019.A004;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Description: <ReView05Array><br>
 * Author: mxdl<br>
 * Date: 2019/9/2<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class ReView05Array {
  // 1.冒泡
  public static int[] buddleSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    return arr;
  }

  // 2.选择
  public static int[] changeSort(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
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

  // 3.桶
  public static int[] buketSor(int[] nums, int max) {
    int[] arr = new int[max + 1];
    for (int i = 0; i < nums.length; i++) {
      arr[nums[i]]++;
    }
    return arr;
  }

  // 4.查找是否有重复元素
  public static boolean isRepeat(int[] nums) {
    HashSet<Integer> hashSet = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (hashSet.contains(nums[i])) {
        return true;
      }
      hashSet.add(nums[i]);
    }
    return false;
  }

  // 5.删除数组中的重复元素
  public static int[] removeRepeat(int[] nums) {
    loop: for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j]) {
          while (j < nums.length - 1) {
            nums[j] = nums[j + 1];
            j++;
          }
          nums = Arrays.copyOf(nums, nums.length - 1);
          continue loop;
        }
      }
    }
    return nums;
  }

  // 6.左上到右下的路径数
  public static int getPathCount(int m, int n) {
    int[][] arr = new int[m][n];
    for (int i = 0; i < n; i++) {
      arr[0][i] = 1;
    }
    for (int i = 0; i < m; i++) {
      arr[i][0] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
      }
    }
    return arr[m - 1][n - 1];
  }

  // 8.两数求和找下标
  public static int[] getIndexBySum(int[] nums, int value) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (hashMap.containsKey(value - nums[i])) {
        return new int[] {i, hashMap.get(value - nums[i])};
      }
      hashMap.put(nums[i], i);
    }
    return null;
  }

  public static int getMinSumByPath(int[][] nums) {
    int m = nums.length;
    int n = nums[0].length;
    int[][] arr = new int[m][n];
    arr[0][0] = nums[0][0];
    for (int i = 1; i < n; i++) {
      arr[0][i] = nums[0][i] + arr[0][i - 1];
    }
    for (int i = 1; i < m; i++) {
      arr[i][0] = nums[i][0] + arr[i - 1][0];
    }
    for (int i = 1; i < m; i++) {// *****
      for (int j = 1; j < n; j++) {
        arr[i][j] = nums[i][j] + Math.min(arr[i][j - 1], arr[i - 1][j]);
      }
    }
    return arr[m - 1][n - 1];
  }

  public static void main(String[] args) {
    int[] arr = {4, 2, 8, 5, 7, 1, 3, 6};
    // int[] ints = changeSort(arr);
    // int[] ints = buketSor(arr, 8);
    // for (int i = 0; i < ints.length; i++) {
    // if (ints[i] > 0) {
    // System.out.println(i);
    // }
    // }
    // System.out.println(Arrays.toString(ints));
    int[] ints = removeRepeat(arr);
    // System.out.println(isRepeat(arr));
    // for (int i = 0; i < ints.length; i++) {
    // System.out.println(ints[i]);
    // }
    // int pathCount = getPathCount(3, 3);
    // System.out.println(pathCount);
//    int[][] arr1 = {{4, 2}, {8, 5}, {7, 1}};
//    int minSumByPath = getMinSumByPath(arr1);
    int[] indexBySum = getIndexBySum(arr, 9);
    System.out.println(Arrays.toString(indexBySum));
  }
}
