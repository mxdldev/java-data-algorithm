package A数组.A002选择排序;

/**
 * Description: <选择排序><br>
 * Author: mxdl<br>
 * Date: 2018/11/21<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAlgorithm {
  public static void main(String[] arg) {
    int[] arr = {3, 10, 1, 34, 5, 21};
    sortChange(arr);
    int i = 0;
    while (i < arr.length) {
      System.out.println(arr[i]);
      i++;
    }
  }

  // 选择排序，选择第一个元素和剩下的n-1个比较
  private static void sortChange(int[] arr) {
    // 第一轮确定第一个元素，第二轮确定第二个元素
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        // 选择第一i个元素和剩余的元素进行比较
        if (arr[i] > arr[j]) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }
}
