package B集合.A001自定义实现一个ArrayList;

import java.util.Arrays;

/**
 * Description: <自定义实现一个ArrayList><br>
 * Author: mxdl<br>
 * Date: 2018/11/19<br>
 * Version: V1.0.0<br>
 * Update: <br>
 */
public class MyArrayList {
  private int[] arr;
  private int initsize = 5;
  private int size = 0;

  public MyArrayList() {
    arr = new int[initsize];
  }

  public int get(int index) {
    return arr[index];
  }

  public boolean add(int value) {
    // 说明此时数组已经满了，要扩容了
    if (size == arr.length) {
      System.out.println("数组要扩容了...");
      arr = Arrays.copyOf(arr, size * 2);
    }
    arr[size++] = value;
    return true;
  }

  public boolean remove(int value) {
    if (arr.length > 0) {
      loop: for (int i = 0; i < arr.length; i++) {
        if (arr[i] == value) {
          int temp = i;
          while (temp < arr.length - 1) {
            arr[temp] = arr[temp + 1];
            temp++;
          }
          arr[--size] = 0;
          break loop;
        }
      }
    }
    return true;
  }

  public int size() {
    return size;
  }
}
