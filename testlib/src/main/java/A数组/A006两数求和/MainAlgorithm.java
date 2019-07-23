package A数组.A006两数求和;

import java.util.Arrays;

/**
 * Description: <><br>
 * Author: mxdl<br>
 * Date: 2018/11/21<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MainAlgorithm {
  public static void main(String[] args) {
    int[] arr = {1, 23, 12, 2, 11, 22};
    int[] res = get(arr, 33);
    System.out.println(Arrays.toString(res));
  }
  static class Data implements Comparable<Data>{
    int index;
    int data;

    public Data(int index, int data) {
      this.index = index;
      this.data = data;
    }

    @Override
    public int compareTo(Data o) {
      return data - o.data;
    }

    @Override
    public String toString() {
      return "Data{" + "index=" + index + ", data=" + data + '}';
    }
  }
  // 指定一个目标数，查找其中两个数之和等于目标数的下标
  public static int[] get(int[] arr, int sum) {
    int[] result = {0, 0};
    // 1.首先对原数组排序
    Data[] arr1 = new Data[arr.length];
    int i = 0;
    while( i < arr.length){
      arr1[i] = new Data(i,arr[i]);
      i++;
    }

    Arrays.sort(arr1);
    System.out.println(Arrays.toString(arr1));
    // 2.声明两个指针，head，tail
    int head = 0;
    int tail = arr.length - 1;
    while (head < tail) {
      if ((arr1[head].data + arr1[tail].data) == sum) {
        result[0] = arr1[head].index;
        result[1] = arr1[tail].index;
        return result;
      } else if ((arr1[head].data + arr1[tail].data) < sum) {
        head++;
      } else {
        tail--;
      }
    }
    return null;
  }
  //方法2：
  public static int[] getSumIndex(int[] arr, int sum) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] + arr[j] == sum) {
          System.out.println("i:" + i + ";j:" + j);
          return new int[]{i,j};
        }
      }
    }
    return null;
  }

}
