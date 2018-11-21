package A数组.A005删除数组重复元素;

import java.util.Arrays;

/**
 * Description: <删除数组重复元素><br>
 * Author: gxl<br>
 * Date: 2018/11/21<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAgorithm {
  public static void main(String[] arg) {
    int[] arr = {1, 3, 10, 1, 34, 5, 21};
    arr = removeRepeat(arr);
    int i = 0;
    while (i < arr.length) {
      System.out.println(arr[i]);
      i++;
    }
  }

  // 查找一个数组里面有没有重复元素，如果有则删除重复元素
  private static int[] removeRepeat(int[] arr) {
    // 取出第一个元素和剩余的其他元素进行对比
    // 一旦发现相等，则后面的元素都往前移动一个，移动完毕数组
    loop: for (int i = 0; i < arr.length; i++) {
      for (int k = i + 1; k < arr.length; k++) {
        // 如果相等则后面的元素同意往前移动
        if (arr[i] == arr[k]) {
          int head = k;
          while (head < arr.length - 1) {
            arr[head] = arr[head + 1];
            head++;
          }
          // 对数组进行压缩处理
          arr = Arrays.copyOf(arr, arr.length - 1);
          i = 0;
          // 压缩完毕，重头开始执行
          continue loop;
        }
      }
    }
    return arr;
  }

}
