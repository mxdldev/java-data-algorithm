package A003桶排序;

/**
 * Description: <桶排序><br>
 * Author: gxl<br>
 * Date: 2018/11/21<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAlgorithm {
  public static void main(String[] arg) {
    int[] arr = {1, 3, 10, 1, 34, 5, 21};
    sortBucket(arr);
//    int i = 0;
//    while (i < arr.length) {
//      System.out.println(arr[i]);
//      i++;
//    }
  }

  // 桶排序，声明一个以 最大元素+1 为长度的数组，遍历原数组，桶数组计数
  private static void sortBucket(int[] arr) {
    int[] arr1 = new int[34 + 1];
    for (int i = 0; i < arr.length; i++) {
      arr1[arr[i]]++;
    }
    for (int i = 0; i < arr1.length; i++) {
      int count = arr1[i];
      while (count > 0) {
        System.out.println(i);
        count--;
      }
    }
  }
}
